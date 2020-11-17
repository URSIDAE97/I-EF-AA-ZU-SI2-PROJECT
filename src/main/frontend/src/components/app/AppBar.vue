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
          link
          :to="{ name: 'UserProfile' }"
        >
          <v-icon>mdi-account-circle-outline</v-icon>
        </v-btn>
      </template>
      <span>Mój profil</span>
    </v-tooltip>

    <div>
      {{ userNameAndSurname }}
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
import { mapActions, mapState } from 'vuex'

export default {
  name: 'AppBar',

  computed: {
    ...mapState([
      'user'
    ]),
    userNameAndSurname () {
      return this.user.name + ' ' + this.user.surname
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
