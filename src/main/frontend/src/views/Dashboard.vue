<template>
  <v-container id="dashboard" class="fill-height ma-0 pa-5">
    <v-col align-self="start">
      <v-row class="mb-5">
        <h3>
          Ankiety rządowe
        </h3>
      </v-row>

      <v-row align="start">
        <div class="card-grid">
          <template v-for="item in items">
            <questionnaire-card
              :key="item.id"
              :questionnaire="item"
            />
          </template>
        </div>
      </v-row>

      <v-row class="my-5">
        <h3>
          Ankiety obywatelskie
        </h3>
      </v-row>

      <v-row align="start">
        <div class="card-grid">
          <template v-for="item in items">
            <questionnaire-card
              :key="item.id"
              :questionnaire="item"
            />
          </template>
        </div>
      </v-row>
    </v-col>
  </v-container>
</template>

<script>
import QuestionnaireCard from '@/components/dashboard/QuestionnaireCard'

export default {
  name: 'Dashboard',

  components: {
    QuestionnaireCard
  },

  data () {
    return {
      items: [
        {
          id: 0,
          title: 'title',
          description: 'description'
        },
        {
          id: 1,
          title: 'title',
          description: 'description'
        },
        {
          id: 2,
          title: 'title',
          description: 'description'
        },
        {
          id: 3,
          title: 'title',
          description: 'description'
        },
        {
          id: 4,
          title: 'title',
          description: 'description'
        },
        {
          id: 5,
          title: 'title',
          description: 'description'
        },
        {
          id: 6,
          title: 'title',
          description: 'description'
        },
        {
          id: 7,
          title: 'title',
          description: 'description'
        }
      ]
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
