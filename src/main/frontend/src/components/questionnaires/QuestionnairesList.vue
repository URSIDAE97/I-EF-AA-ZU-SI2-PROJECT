<template>
  <v-list two-line>
    <v-list-item-group>
      <template v-for="(questionnaire, index) in questionnaires">
        <v-list-item :key="questionnaire.id">
            <v-list-item-content>
              <v-list-item-title class="pb-2">
                {{ questionnaire.title }}
              </v-list-item-title>
              <v-list-item-subtitle>
                {{ questionnaire.description }}
              </v-list-item-subtitle>
            </v-list-item-content>

            <v-list-item-action>
              <v-list-item-action-text>
                {{ questionnaire.added }}
              </v-list-item-action-text>

              <v-row>
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
              </v-row>
            </v-list-item-action>
        </v-list-item>

        <v-divider
          v-if="index < questionnaires.length - 1"
          :key="index"
        ></v-divider>
      </template>
    </v-list-item-group>
  </v-list>
</template>

<script>
export default {
  name: 'QuestionnairesList',

  props: {
    questionnaires: {
      type: Array,
      default () {
        return []
      }
    }
  }
}
</script>