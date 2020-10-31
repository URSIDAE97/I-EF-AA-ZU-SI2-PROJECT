<template>
  <v-tabs
    id="polls"
    class="ma-0 pa-5"
  >
    <v-tab>Ankiety rządowe</v-tab>
    <v-tab>Ankiety obywatelskie</v-tab>

    <v-tab-item>
      <polls-list
        :polls="items"
      />
    </v-tab-item>

    <v-tab-item>
      <polls-list
        :polls="items"
      />
    </v-tab-item>
  </v-tabs>
</template>

<script>
import PollsList from '@/components/polls/PollsList'

export default {
  name: 'Polls',

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
