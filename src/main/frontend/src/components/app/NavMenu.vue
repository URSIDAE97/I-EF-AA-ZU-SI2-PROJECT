<template>
  <v-navigation-drawer
    :mini-variant.sync="drawer"
    app
    permanent
  >
    <v-list-item class="px-2">
      <v-app-bar-nav-icon @click="drawer = !drawer" />
    </v-list-item>

    <v-divider></v-divider>

    <v-list dense>
      <v-list-item
        link
        :to="{ name: 'Dashboard' }"
      >
        <v-list-item-icon>
          <v-icon>
            mdi-view-dashboard-outline
          </v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>
            Dashboard
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-list-item
        link
        :to="{ name: 'Polls' }"
      >
        <v-list-item-icon>
          <v-icon>
            mdi-poll-box-outline
          </v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>
            Ankiety
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-list-item
        link
        :to="{ name: 'MyPolls' }"
      >
        <v-list-item-icon>
          <v-icon>
            mdi-star-outline
          </v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>
            Moje ankiety
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-list-item
        link
        :to="{ name: 'AdminPanel' }"
      >
        <v-list-item-icon>
          <v-icon>
            mdi-cog-outline
          </v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>
            Panel administratora
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
export default {
  name: 'NavMenu',

  data () {
    return {
      drawer: false
    }
  }
}
</script>
