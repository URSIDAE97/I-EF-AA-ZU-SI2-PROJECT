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
          @click="logout()"
        >
          <v-icon>mdi-logout</v-icon>
        </v-btn>
      </template>
      <span>Wyloguj</span>
    </v-tooltip>
  </v-app-bar>
</template>

<script>
import { clearAuthToken } from '@/services/local_storage_service.js'
import { mapActions } from 'vuex'

export default {
  name: 'AppBar',

  data () {
    return {
      user: {
        name: 'Adam Kowalski'
      }
    }
  },

  methods: {
    ...mapActions([
      'setUserInfo'
    ]),
    logout () {
      clearAuthToken()
      this.setUserInfo()
      this.$router.push({ name: 'Login' })
    }
  }
}
</script>
