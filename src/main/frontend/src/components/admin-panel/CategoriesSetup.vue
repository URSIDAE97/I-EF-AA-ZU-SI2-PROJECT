<template>
  <div>
    <v-container>
      <v-row justify="end">
        <v-btn
          tile
          color="primary"
          link
          :to="{ name: 'EditCategory', params: { id: 'new' } }"
        >
          <v-icon left>
            mdi-plus
          </v-icon>
          Utwórz nową
        </v-btn>
      </v-row>
    </v-container>
    <v-list two-line>
      <v-list-item-group>
        <template v-for="(category, index) in categories.data">
          <v-list-item :key="category.id">
              <v-list-item-content>
                <v-list-item-title class="pb-2">
                  {{ category.summary }}
                </v-list-item-title>
                <v-list-item-subtitle>
                  {{ category.description }}
                </v-list-item-subtitle>
              </v-list-item-content>

              <v-list-item-action>
                <v-row>
                  <v-tooltip bottom>
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        icon
                        v-bind="attrs"
                        v-on="on"
                        link
                        :to="{ name: 'EditCategory', params: { id: category.id } }"
                      >
                        <v-icon>mdi-pencil</v-icon>
                      </v-btn>
                    </template>
                    <span>EDYTUJ</span>
                  </v-tooltip>

                  <v-tooltip bottom>
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        icon
                        v-bind="attrs"
                        v-on="on"
                        @click="removeCategory(category)"
                      >
                        <v-icon>mdi-delete</v-icon>
                      </v-btn>
                    </template>
                    <span>USUŃ</span>
                  </v-tooltip>
                </v-row>
              </v-list-item-action>
          </v-list-item>

          <v-divider
            v-if="index < categories.data.length - 1"
            :key="index"
          ></v-divider>
        </template>
      </v-list-item-group>
    </v-list>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  name: 'CategoriesSetup',

  data () {
    return {
    }
  },

  computed: {
    ...mapState([
      'categories'
    ])
  },

  methods: {
    ...mapActions([
      'getCategories',
      'deleteCategory'
    ]),
    removeCategory (category) {
      this.deleteCategory(category.id)
    }
  },

  mounted () {
    const self = this
    if (!self.categories.loaded) {
      self.getCategories()
    }
  }
}
</script>