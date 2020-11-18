<template>
  <v-tabs
    id="my-questionnaires"
    class="ma-0 pa-5"
  >
    <v-tab>Aktywne</v-tab>
    <v-tab>Wersje robocze</v-tab>

    <v-tab-item>
      <questionnaires-list
        :questionnaires="items"
      />
    </v-tab-item>

    <v-tab-item>
      <v-container>
        <v-row justify="end">
          <v-btn
            tile
            color="primary"
            link
            :to="{ name: 'EditQuestionnaire' }"
          >
            <v-icon left>
              mdi-plus
            </v-icon>
            Utwórz nową
          </v-btn>
        </v-row>
      </v-container>
      <questionnaires-list
        :questionnaires="items"
      />
    </v-tab-item>
  </v-tabs>
</template>

<script>
import QuestionnairesList from '@/components/questionnaires/QuestionnairesList'

export default {
  name: 'MyQuestionnaires',

  components: {
    QuestionnairesList
  },

  data () {
    return {
      items: [
        {
          id: 0,
          title: 'title',
          description: 'description',
          added: '5 min ago'
        },
        {
          id: 1,
          title: 'title',
          description: 'description',
          added: '5 min ago'
        },
        {
          id: 2,
          title: 'title',
          description: 'description',
          added: '5 min ago'
        },
        {
          id: 3,
          title: 'title',
          description: 'description',
          added: '5 min ago'
        },
        {
          id: 4,
          title: 'title',
          description: 'description',
          added: '5 min ago'
        },
        {
          id: 5,
          title: 'title',
          description: 'description',
          added: '5 min ago'
        },
        {
          id: 6,
          title: 'title',
          description: 'description',
          added: '5 min ago'
        },
        {
          id: 7,
          title: 'title',
          description: 'description',
          added: '5 min ago'
        }
      ]
    }
  }
}
</script>
