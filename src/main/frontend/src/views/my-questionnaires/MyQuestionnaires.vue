<template>
  <v-tabs
    id="my-questionnaires"
    class="ma-0 pa-5"
  >
    <v-tab>Aktywne</v-tab>
    <v-tab>Wersje robocze</v-tab>

    <v-tab-item>
      <questionnaires-list
        :questionnaires="activeQuestionnaires"
      />
    </v-tab-item>

    <v-tab-item>
      <v-container>
        <v-row justify="end">
          <v-btn
            tile
            color="primary"
            link
            :to="{ name: 'EditQuestionnaire', params: { id: 'new' } }"
          >
            <v-icon left>
              mdi-plus
            </v-icon>
            Utwórz nową
          </v-btn>
        </v-row>
      </v-container>
      <questionnaires-list
        :questionnaires="wipQuestionnaires"
        :edit="true"
        @edit="editQuestionnaire($event)"
        @delete="removeQuestionnaire($event)"
        @activate="publishQuestionnaire($event)"
      />
    </v-tab-item>
  </v-tabs>
</template>

<script>
import QuestionnairesList from '@/components/questionnaires/QuestionnairesList'
import { mapActions, mapState, mapGetters } from 'vuex'

export default {
  name: 'MyQuestionnaires',

  components: {
    QuestionnairesList
  },

  data () {
    return {
    }
  },

  computed: {
    ...mapState([
      'questionnaires'
    ]),
    ...mapGetters([
      'activeQuestionnaires',
      'wipQuestionnaires'
    ])
  },

  methods: {
    ...mapActions([
      'getQuestionnaires',
      'deleteQuestionnaire',
      'activateQuestionnaire'
    ]),
    editQuestionnaire (id) {
      this.$router.push({ name: 'EditQuestionnaire', params: { id: id } })
    },
    removeQuestionnaire (id) {
      this.deleteQuestionnaire(id)
    },
    publishQuestionnaire (id) {
      this.activateQuestionnaire(id)
    }
  },

  mounted () {
    const self = this
    if (!self.questionnaires.loaded) {
      self.getQuestionnaires()
    }
  }
}
</script>
