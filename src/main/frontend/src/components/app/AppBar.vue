<template>
  <v-app-bar app>
    <v-toolbar-title>
      Ankiety
    </v-toolbar-title>
    <v-spacer/>

    <v-tooltip bottom>
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          icon
          v-bind="attrs"
          v-on="on"
        >
          <v-icon>mdi-account-circle-outline</v-icon>
        </v-btn>
      </template>
      <span>Mój profil</span>
    </v-tooltip>

    <div>
      {{ user.name }}
    </div>

    <v-tooltip bottom>
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          icon
          v-bind="attrs"
          v-on="on"
        >
          <v-icon>mdi-logout</v-icon>
        </v-btn>
      </template>
      <span>Wyloguj</span>
    </v-tooltip>
  </v-app-bar>
</template>

<script>
export default {
  name: 'AppBar',

  data () {
    return {
      user: {
        name: 'Adam Kowalski'
      }
    }
  }
}
</script>
