<template>
  <div>
    <v-container>
      <v-row justify="end">
        <v-btn
          tile
          color="primary"
          link
          :to="{ name: 'EditCategory' }"
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
        <template v-for="(category, index) in categories">
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
            v-if="index < categories.length - 1"
            :key="index"
          ></v-divider>
        </template>
      </v-list-item-group>
    </v-list>
  </div>
</template>

<script>
export default {
  name: 'CategoriesSetup',

  data () {
    return {
      categories: [
        {
          id: 0,
          summary: 'ajdhdsa',
          description: 'oishfjhsdjfjsdjfhsjdhfjhsf jsdhfjhsdjfh sdkfsdjf sfkjsdkfj sdfkjsdfkj'
        },
        {
          id: 1,
          summary: 'ajdhdsa',
          description: 'oishfjhsdjfjsdjfhsjdhfjhsf jsdhfjhsdjfh sdkfsdjf sfkjsdkfj sdfkjsdfkj'
        },
        {
          id: 2,
          summary: 'ajdhdsa',
          description: 'oishfjhsdjfjsdjfhsjdhfjhsf jsdhfjhsdjfh sdkfsdjf sfkjsdkfj sdfkjsdfkj'
        }
      ]
    }
  }
}
</script>