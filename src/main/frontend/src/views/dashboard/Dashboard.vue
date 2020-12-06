<template>
  <v-container id="dashboard" class="fill-height ma-0 pa-5">
    <v-col align-self="start">
      <template
        v-for="category in categories.data"
      >
        <v-row :key="'header_' + category.id" class="my-5">
          <h3>
            {{ category.summary }}
          </h3>
        </v-row>

        <v-row :key="'grid_' + category.id" align="start">
          <div class="card-grid">
            <template v-for="questionnaire in questionairesByCategory[category.id]">
              <questionnaire-card
                :key="'grid_item_' + questionnaire.id"
                :questionnaire="questionnaire"
              />
            </template>
          </div>
        </v-row>
      </template>
    </v-col>
  </v-container>
</template>

<script>
import QuestionnaireCard from '@/components/dashboard/QuestionnaireCard'
import { mapState, mapActions, mapGetters } from 'vuex'
import { groupBy } from 'lodash'

export default {
  name: 'Dashboard',

  components: {
    QuestionnaireCard
  },

  data () {
    return {
    }
  },

  computed: {
    ...mapState([
      'categories',
      'questionnaires'
    ]),
    ...mapGetters([
      'activeQuestionnaires'
    ]),
    questionairesByCategory () {
      const self = this
      return groupBy(self.activeQuestionnaires, 'idCategory')
    }
  },

  methods: {
    ...mapActions([
      'getCategories',
      'getQuestionnaires'
    ])
  },

  mounted () {
    const self = this
    if (!self.categories.loaded) {
      self.getCategories()
    }
    if (!self.questionnaires.loaded) {
      self.getQuestionnaires()
    }
  }
}
</script>

<style scoped>
.card-grid {
  display: flex;
  flex-wrap: wrap;
  grid-gap: 20px;
  align-items: flex-start;
}
</style>
