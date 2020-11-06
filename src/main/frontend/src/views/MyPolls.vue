<template>
  <v-tabs
    id="my-polls"
    class="ma-0 pa-5"
  >
    <v-tab>Aktywne</v-tab>
    <v-tab>Wersje robocze</v-tab>

    <v-tab-item>
      <polls-list
        :polls="items"
      />
    </v-tab-item>

    <v-tab-item>
      <v-container>
        <v-row justify="end">
          <v-btn
            tile
            color="primary"
            link
            :to="{ name: 'EditPoll' }"
          >
            <v-icon left>
              mdi-plus
            </v-icon>
            Utwórz nową
          </v-btn>
        </v-row>
      </v-container>
      <polls-list
        :polls="items"
      />
    </v-tab-item>
  </v-tabs>
</template>

<script>
import PollsList from '@/components/polls/PollsList'

export default {
  name: 'MyPolls',

  components: {
    PollsList
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
