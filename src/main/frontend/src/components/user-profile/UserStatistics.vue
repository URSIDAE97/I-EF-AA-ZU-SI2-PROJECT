<template>
  <v-form>
    <v-container class="pa-3 ma-0">
      <v-row style="width: 500px;">
        <v-col>
          <p>
            <b>Wypełnione ankiety: </b>
            {{ statistics.questionnairesDone }}
          </p>
          <p>
            <b>Ankiety w trakcie wypełniania: </b>
            {{ statistics.questionnairesInProgress }}
          </p>
        </v-col>
      </v-row>
    </v-container>
  </v-form>
</template>

<script>
export default {
  name: 'UserStatistics',

  data () {
    return {
      statistics: {
        questionnairesDone: 15,
        questionnairesInProgress: 3
      }
    }
  }
}
</script>
