<template>
  <v-form id="edit-category">
    <v-container class="pa-3 ma-0">
      <v-row style="width: 800px;">
        <v-col v-if="categoryInfo">
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
                {{ btnAction }}
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
import { mapState, mapActions } from 'vuex'

export default {
  name: 'EditCategory',

  data() {
    return {
      categoryInfo: null,
      formError: false
    }
  },

  computed: {
    ...mapState([
      'categories'
    ]),
    title () {
      return this.$route.params.id !== 'new' ? 'Edytuj kategorię' : 'Nowa kategoria'
    },
    btnAction () {
      return this.$route.params.id !== 'new' ? 'AKTUALIZUJ' : 'DODAJ'
    }
  },

  methods: {
    ...mapActions([
      'getCategories',
      'addCategory',
      'editCategory'
    ]),
    updateCategory () {
      const self = this
      const id = self.$route.params.id
      if (id === 'new') {
        self.addCategory(self.categoryInfo)
          .then(() => {
            self.$router.push({ name: 'AdminPanel' })
          })
      } else {
        self.editCategory(self.categoryInfo)
          .then(() => {
            self.$router.push({ name: 'AdminPanel' })
          })
      }
    },
    closeUpdateForm () {
      this.$router.push({ name: 'AdminPanel' })
    }
  },

  mounted () {
    const self = this
    const id = self.$route.params.id=== 'new' ? self.$route.params.id : parseInt(self.$route.params.id)
    if (id === 'new') {
      self.categoryInfo = {
        summary: '',
        description: ''
      }
    } else {
      if (!self.categories.loaded) {
        self.getCategories()
          .then(() => {
            self.categoryInfo = Object.assign({}, self.categories.data.find(c => c.id === id))
          })
      } else {
        self.categoryInfo = Object.assign({}, self.categories.data.find(c => c.id === id))
      }
    }
  }
}
</script>
