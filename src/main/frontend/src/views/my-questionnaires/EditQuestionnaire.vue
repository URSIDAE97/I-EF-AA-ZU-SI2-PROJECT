<template>
  <v-container id="edit-questionnaire" class="ma-0 pa-5">
    <v-row justify="end">
      <v-btn
        tile
        color="success"
        @click="saveQuestionnaire()"
      >
        <v-icon left>
          mdi-check-circle-outline
        </v-icon>
        Zapisz
      </v-btn>
      <v-btn
        tile
        color="primary"
        @click="discardChanges()"
        class="ml-5"
      >
        <v-icon left>
          mdi-close-circle-outline
        </v-icon>
        Anuluj
      </v-btn>
    </v-row>
    <v-row>
      <h3>
        Szczegóły
      </h3>
    </v-row>
    <v-row v-if="questionnaireInfo">
      <text-input
        v-model="questionnaireInfo.title"
        label="Tytuł"
        icon="mdi-pencil"
        :error="formError"
        :maxlength="50"
        name="title"
        @input="formError = false"
        @enter="saveQuestionnaire()"
      />
    </v-row>
    <v-row v-if="questionnaireInfo">
      <text-area
        v-model="questionnaireInfo.description"
        label="Opis"
        icon="mdi-pencil"
        :error="formError"
        :maxlength="100"
        name="description"
        @input="formError = false"
        @enter="saveQuestionnaire()"
      />
    </v-row>
    <v-row v-if="questionnaireInfo">
      <single-select
        :value="selectedCategory"
        label="Kategoria"
        icon="mdi-format-list-bulleted-square"
        :error="formError"
        name="category"
        :options="categoriesOptions"
        @input="selectCategory($event)"
      />
    </v-row>
    <v-row class="mt-5">
      <v-col>
        <h3>
          Pytania
        </h3>
      </v-col>
      <v-spacer />
      <v-col>
        <v-btn
          tile
          color="primary"
          @click="addQuestion()"
        >
          <v-icon left>
            mdi-plus
          </v-icon>
          Dodaj
        </v-btn>
      </v-col>
    </v-row>
    <template v-if="questionnaireInfo">
      <v-row
        v-for="(question, index) in questionnaireInfo.question"
        :key="index"
        class="mb-5"
      >
        <v-card outlined width="100%">
          <v-row class="mx-5">
            <text-input
              v-model="question.text"
              label="Tytuł"
              icon="mdi-pencil"
              :error="formError"
              :maxlength="100"
              name="title"
              @input="formError = false"
            />
          </v-row>

          <v-row class="mx-5">
            <v-col>
              <h4>
                Opcje
              </h4>
            </v-col>
            <v-spacer />
            <v-col>
              <v-btn
                tile
                color="primary"
                @click="addOptionToQuestion(question)"
              >
                <v-icon left>
                  mdi-plus
                </v-icon>
                Dodaj
              </v-btn>
            </v-col>
          </v-row>

          <v-row
            v-for="(option, index) in question.option"
            :key="index"
            class="mx-5"
          >
            <text-input
              v-model="option.text"
              label="Tytuł"
              icon="mdi-radiobox-blank"
              :error="formError"
              :maxlength="100"
              name="title"
              @input="formError = false"
            />
            <v-tooltip bottom>
              <template v-slot:activator="{ on, attrs }">
                <v-btn
                  icon
                  v-bind="attrs"
                  v-on="on"
                  @click="removeOption(question, index)"
                  style="margin: auto;"
                >
                  <v-icon>mdi-delete-outline</v-icon>
                </v-btn>
              </template>
              <span>Usuń opcję</span>
            </v-tooltip>
          </v-row>

          <v-card-actions>
            <v-spacer />
            <v-tooltip bottom>
              <template v-slot:activator="{ on, attrs }">
                <v-btn
                  icon
                  v-bind="attrs"
                  v-on="on"
                  @click="removeQuestion(index)"
                >
                  <v-icon>mdi-delete-outline</v-icon>
                </v-btn>
              </template>
              <span>Usuń pytanie</span>
            </v-tooltip>
          </v-card-actions>
        </v-card>
      </v-row>
    </template>
  </v-container>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  name: "EditQuestionnaire",

  data () {
    return {
      questionnaireInfo: null,
      formError: false
    }
  },

  computed: {
    ...mapState([
      'categories',
      'questionnaires'
    ]),
    categoriesOptions () {
      const self = this
      return self.categories.data.map(c => c.summary)
    },
    selectedCategory () {
      const self = this
      const category = self.categories.data.find(c => c.id === self.questionnaireInfo.idCategory)
      if (category) {
        return category.summary
      } else {
        return null
      }
    }
  },

  methods: {
    ...mapActions([
      'getCategories',
      'getQuestionnaires',
      'addQuestionnaire',
      'editQuestionnaire'
    ]),
    selectCategory (categoryName) {
      const self = this
      const category = self.categories.data.find(c => c.summary === categoryName)
      if (category) {
        self.questionnaireInfo.idCategory = category.id
      } else {
        self.questionnaireInfo.idCategory = null
      }
    },
    addQuestion () {
      const self = this
      self.questionnaireInfo.question.push({
        text: '',
        questionnaireId: self.questionnaireInfo.id ? self.questionnaireInfo.id : null,
        option: []
      })
    },
    addOptionToQuestion (question) {
      const self = this
      question.option.push({
        text: '',
        questionId: question.id ? question.id : null
      })
    },
    removeQuestion (questionIndex) {
      const self = this
      self.questionnaireInfo.question.splice(questionIndex, 1)
    },
    removeOption (question, optionIndex) {
      const self = this
      question.option.splice(optionIndex, 1)
    },
    saveQuestionnaire () {
      const self = this
      if (self.$route.params.id === 'new') {
        self.addQuestionnaire(self.questionnaireInfo)
          .then(() => {
            self.$router.push({ name: 'MyQuestionnaires' })
          })
      } else {
        self.editQuestionnaire(self.questionnaireInfo)
          .then(() => {
            self.$router.push({ name: 'MyQuestionnaires' })
          })
      }
    },
    discardChanges () {
      this.$router.push({ name: 'MyQuestionnaires' })
    }
  },

  mounted () {
    const self = this
    const id = self.$route.params.id === 'new' ? self.$route.params.id : parseInt(self.$route.params.id)
    if (!self.categories.loaded) {
      self.getCategories()
    }
    if (id !== 'new') {
      if (!self.questionnaires.loaded) {
        self.getQuestionnaires()
          .then(() => {
            self.questionnaireInfo = Object.assign({}, self.questionnaires.data.find(q => q.id === id))
          })
      } else {
        self.questionnaireInfo = Object.assign({}, self.questionnaires.data.find(q => q.id === id))
      }
    } else {
      self.questionnaireInfo = {
        title: '',
        description: '',
        idCategory: null,
        question: []
      }
    }
  }
}
</script>