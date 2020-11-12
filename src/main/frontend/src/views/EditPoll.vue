<template>
  <v-container id="edit-poll" class="ma-0 pa-5">
    <v-row>
      <h3>
        Szczegóły
      </h3>
    </v-row>
    <v-row>
      <v-text-field
        v-model="poll.name"
        label="Tytuł"
      >
        <v-icon slot="prepend">
          mdi-pencil-outline
        </v-icon>
      </v-text-field>
    </v-row>
    <v-row>
      <v-textarea
        v-model="poll.description"
        label="Opis"
      >
        <v-icon slot="prepend">
          mdi-pencil-outline
        </v-icon>
      </v-textarea>
    </v-row>
    <v-row>
      <v-col>
        <h3>
          Pytania
        </h3>
      </v-col>
      <v-spacer />
      <v-col>
        <v-btn
          tile
          color="primary"
          link
          :to="{ name: 'EditPoll' }"
        >
          <v-icon left>
            mdi-plus
          </v-icon>
          Dodaj
        </v-btn>
      </v-col>
    </v-row>
    <v-row
      v-for="question in poll.questions"
      :key="question.id"
    >
      <v-card outlined width="100%">
        <v-row>
          <v-text-field
            v-model="question.title"
            label="Tytuł"
          >
            <v-icon slot="prepend">
              mdi-pencil-outline
            </v-icon>
          </v-text-field>
        </v-row>

        <v-row>
          <v-col>
            <h4>
              Opcje
            </h4>
          </v-col>
          <v-spacer />
          <v-col>
            <v-btn
              tile
              color="primary"
              link
              :to="{ name: 'EditPoll' }"
            >
              <v-icon left>
                mdi-plus
              </v-icon>
              Dodaj
            </v-btn>
          </v-col>
        </v-row>



        <v-row v-for="option in question.options" :key="option.id">
          <v-text-field
            v-model="option.title"
            label="Tytuł"
          >
            <v-icon slot="prepend">
              mdi-radiobox-blank
            </v-icon>
          </v-text-field>
        </v-row>

        <v-card-actions>
          <v-spacer />
          <v-tooltip bottom>
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                icon
                v-bind="attrs"
                v-on="on"
              >
                <v-icon>mdi-delete-outline</v-icon>
              </v-btn>
            </template>
            <span>Usuń pytanie</span>
          </v-tooltip>
        </v-card-actions>
      </v-card>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "EditPoll",

  data () {
    return {
      poll: {
        name: '',
        description: '',
        questions: [
          {
            id: 0,
            title: '',
            options: [
              {
                id: 0,
                title: ''
              },
              {
                id: 1,
                title: ''
              }
            ]
          }
        ]
      },
      question: {
        id: 0,
        title: '',
        options: []
      },
      option: {
        id: 0,
        title: ''
      }
    }
  }
}
</script>