<template>
  <v-form id="edit-category">
    <v-container class="pa-3 ma-0">
      <v-row style="width: 800px;">
        <v-col>
          <!-- TITLE -->
          <h4>
            <b>{{ title }}</b>
          </h4>

          <!-- EDIT FORM -->
          <text-input
            v-model="categoryInfo.summary"
            label="Nazwa"
            icon="mdi-pencil"
            :error="formError"
            :maxlength="50"
            name="summary"
            @input="formError = false"
            @enter="updateCategory()"
          />
          <text-area
            v-model="categoryInfo.description"
            label="Opis"
            icon="mdi-pencil"
            :error="formError"
            :maxlength="100"
            name="description"
            @input="formError = false"
            @enter="updateCategory()"
          />

          <v-row class="mt-2">
            <v-col>
              <v-btn
                color="success"
                @click="updateCategory()"
              >
                <v-icon left>
                  mdi-check-circle-outline
                </v-icon>
                AKTUALIZUJ
              </v-btn>
            </v-col>
            <v-col>
              <v-btn
                color="primary"
                @click="closeUpdateForm()"
              >
                <v-icon left>
                  mdi-close-circle-outline
                </v-icon>
                ANULUJ
              </v-btn>
            </v-col>
          </v-row>
        </v-col>
      </v-row>
    </v-container>
  </v-form>
</template>

<script>
export default {
  name: 'EditCategory',

  data() {
    return {
      categoryInfo: null,
      formError: false
    }
  },

  computed: {
    title () {
      return this.$route.query.id ? 'Edytuj kategorię' : 'Nowa kategoria'
    }
  },

  methods: {
    updateCategory () {

    }
  }
}
</script>
