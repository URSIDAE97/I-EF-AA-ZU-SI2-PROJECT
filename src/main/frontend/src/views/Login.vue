<template>
  <v-row
    justify="center"
    align="center"
    class="fill-height"
  >
    <v-col
      align="center"
      justify="center"
    >
      <v-card
        elevation="2"
        outlined
        class="pa-10"
        style="width: 350px;"
      >
        <text-input
          v-model="loginData.username"
          label="Nazwa użytkownika"
          icon="mdi-account"
          :error="loginError"
          :maxlength="20"
          name="username"
          @input="loginError = false"
          @enter="login()"
        />
        <password-input
          v-model="loginData.password"
          label="Hasło"
          icon="mdi-lock"
          :error="loginError"
          :maxlength="20"
          name="password"
          @input="loginError = false"
          @enter="login()"
        />
        <v-btn
          color="primary"
          @click="login()"
        >
          ZALOGUJ
        </v-btn>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import { authenticate_user } from '@/services/authentication_service.js'
import { setAuthToken } from '@/services/local_storage_service.js'
import { mapActions } from 'vuex'

export default {
  name: 'Login',

  data () {
    return {
      loginData: {
        username: '',
        password: ''
      },
      loginError: false,
      loading: false
    }
  },

  methods: {
    ...mapActions([
      'setUserInfo'
    ]),
    login () {
      let self = this
      authenticate_user(self.loginData)
        .then((data) => {
          setAuthToken(data.access_token)
          self.setUserInfo()
          self.$router.push({ name: 'Dashboard' })
        })
        .catch((error) => {
          self.loginError = true
        })
    }
  }
}
</script>
