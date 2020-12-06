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
                <v-tooltip bottom v-if="edit">
                  <template v-slot:activator="{ on, attrs }">
                    <v-btn
                      icon
                      v-bind="attrs"
                      v-on="on"
                      @click="$emit('edit', questionnaire.id)"
                    >
                      <v-icon>mdi-pencil</v-icon>
                    </v-btn>
                  </template>
                  <span>Edytuj</span>
                </v-tooltip>

                <v-tooltip bottom v-if="edit">
                  <template v-slot:activator="{ on, attrs }">
                    <v-btn
                      icon
                      v-bind="attrs"
                      v-on="on"
                      @click="$emit('activate', questionnaire.id)"
                    >
                      <v-icon>mdi-file-upload</v-icon>
                    </v-btn>
                  </template>
                  <span>Aktywuj</span>
                </v-tooltip>

                <v-tooltip bottom v-if="edit">
                  <template v-slot:activator="{ on, attrs }">
                    <v-btn
                      icon
                      v-bind="attrs"
                      v-on="on"
                      @click="$emit('delete', questionnaire.id)"
                    >
                      <v-icon>mdi-delete</v-icon>
                    </v-btn>
                  </template>
                  <span>Usuń</span>
                </v-tooltip>

                <v-tooltip bottom v-if="!edit">
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

                <v-tooltip bottom v-if="!edit">
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
    },
    edit: {
      type: Boolean,
      default: false
    }
  }
}
</script>