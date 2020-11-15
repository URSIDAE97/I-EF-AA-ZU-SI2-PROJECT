<template>
  <v-card
    width="250"
    outlined
  >
    <v-list-item three-line>
      <v-list-item-content>
        <v-list-item-title class="headline mb-1">
          {{ questionnaire.title }}
        </v-list-item-title>
        <v-list-item-subtitle>
          {{ questionnaire.description }}
        </v-list-item-subtitle>
      </v-list-item-content>
    </v-list-item>

    <v-card-actions>
      <v-tooltip bottom>
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            icon
            v-bind="attrs"
            v-on="on"
          >
            <v-icon>mdi-playlist-check</v-icon>
          </v-btn>
        </template>
        <span>Wypełnij</span>
      </v-tooltip>

      <v-tooltip bottom>
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            icon
            v-bind="attrs"
            v-on="on"
          >
            <v-icon>mdi-poll-box-outline</v-icon>
          </v-btn>
        </template>
        <span>Wyniki</span>
      </v-tooltip>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  name: 'QuestionnaireCard',

  props: {
    questionnaire: {
      type: Object,
      required: true
    }
  }
}
</script>