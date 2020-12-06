<template>
  <v-container id="questionnaire" class="ma-0 pa-5">
    <v-row justify="end">
      <v-btn
        tile
        color="success"
        @click="saveAnwsers()"
      >
        <v-icon left>
          mdi-check-circle-outline
        </v-icon>
        Zapisz
      </v-btn>
      <v-btn
        tile
        color="error"
        @click="discardAnwsers()"
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
    <v-row v-if="questionnaireInfo" class="mt-5">
      <b class="mr-2">Tytuł:</b>
      {{ questionnaireInfo.title }}
    </v-row>
    <v-row v-if="questionnaireInfo" class="mt-2">
      <b class="mr-3">Opis:</b>
      {{ questionnaireInfo.description }}
    </v-row>
    <v-row v-if="questionnaireInfo" class="mt-2">
      <b class="mr-2">Kategoria:</b>
      {{ selectedCategory }}
    </v-row>
    <v-row class="my-5">
      <h3>
        Pytania
      </h3>
    </v-row>
    <template v-if="questionnaireInfo">
      <v-row
        v-for="(question, index) in questionnaireInfo.question"
        :key="index"
        class="mb-5"
      >
        <v-card outlined width="100%">
          <v-row class="mx-5 mt-5">
            <b class="mr-2">Treść:</b>
            {{ question.text }}
          </v-row>

          <v-row class="mx-5 mt-3">
            <b>Opcje</b>
          </v-row>

          <v-row
            class="mx-5 mb-5"
          >
            <v-radio-group v-model="radioGroup">
              <v-radio
                v-for="(option, index) in question.option"
                :key="index"
                :label="option.text"
                :value="option.id"
              ></v-radio>
            </v-radio-group>
          </v-row>
        </v-card>
      </v-row>
    </template>
  </v-container>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  name: "Questionnaire",

  data () {
    return {
      questionnaireInfo: null
    }
  },

  computed: {
    ...mapState([
      'categories',
      'questionnaires'
    ]),
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
      'getQuestionnaires'
    ]),
    saveAnwsers () {
      // TODO
    },
    discardAnwsers () {
      this.$router.go(-1)
    }
  },

  mounted () {
    const self = this
    const id = parseInt(self.$route.params.id)
    if (!self.categories.loaded) {
      self.getCategories()
    }
    if (!self.questionnaires.loaded) {
      self.getQuestionnaires()
        .then(() => {
          self.questionnaireInfo = Object.assign({}, self.questionnaires.data.find(q => q.id === id))
        })
    } else {
      self.questionnaireInfo = Object.assign({}, self.questionnaires.data.find(q => q.id === id))
    }
  }
}
</script>