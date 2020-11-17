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
        :loading="loading"
        style="width: 350px;"
      >
        <div class="pa-10">
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
            color="success"
            @click="login()"
          >
            ZALOGUJ
          </v-btn>
          <p class="text-caption my-3">
            nie masz jeszcze konta?
          </p>
          <v-btn
            color="primary"
            small
            link
            :to="{ name: 'Signup' }"
          >
            ZAREJESTRUJ SIĘ
          </v-btn>
        </div>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import { authenticateUser } from '@/services/authentication_service.js'
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
      self.loading = true
      if (self.validateLoginForm()) {
        authenticateUser(self.loginData)
          .then((token) => {
            setAuthToken(token)
            self.setUserInfo()
            self.loading = false
            self.$router.push({ name: 'Dashboard' })
          })
          .catch((error) => {
            self.loginError = true
            self.loading = false
          })
      } else {
        self.loading = false
      }
    },
    validateLoginForm () {
      return this.loginData.username.trim() !== '' &&
        this.loginData.password.trim() !== ''
    }
  }
}
</script>
