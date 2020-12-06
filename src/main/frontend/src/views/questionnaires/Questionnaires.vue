<template>
  <v-tabs
    id="questionnaires"
    class="ma-0 pa-5"
  >
    <v-tab
      v-for="category in categories.data"
      :key="'tab_' + category.id"
    >
      {{ category.summary }}
    </v-tab>

    <v-tab-item
      v-for="category in categories.data"
      :key="'tab_item_' + category.id"
    >
      <questionnaires-list
        :questionnaires="questionairesByCategory[category.id]"
      />
    </v-tab-item>
  </v-tabs>
</template>

<script>
import QuestionnairesList from '@/components/questionnaires/QuestionnairesList'
import { mapState, mapActions, mapGetters } from 'vuex'
import { groupBy } from 'lodash'

export default {
  name: 'Questionnaires',

  components: {
    QuestionnairesList
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
