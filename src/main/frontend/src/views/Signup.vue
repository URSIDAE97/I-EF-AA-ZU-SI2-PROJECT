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
            v-model="signupData.name"
            label="Imie"
            icon="mdi-account"
            :error="signupError"
            :maxlength="20"
            name="name"
            @input="signupError = false"
            @enter="signup()"
          />
          <text-input
            v-model="signupData.surname"
            label="Nazwisko"
            icon="mdi-account"
            :error="signupError"
            :maxlength="20"
            name="surname"
            @input="signupError = false"
            @enter="signup()"
          />
          <text-input
            v-model="signupData.username"
            label="Nazwa użytkownika"
            icon="mdi-account"
            :error="signupError"
            :maxlength="20"
            name="username"
            @input="signupError = false"
            @enter="signup()"
          />
          <text-input
            v-model="signupData.email"
            label="Email"
            icon="mdi-email"
            :error="signupError"
            :maxlength="20"
            name="email"
            @input="signupError = false"
            @enter="signup()"
          />
          <password-input
            v-model="signupData.password"
            label="Hasło"
            icon="mdi-lock"
            :error="signupError"
            :maxlength="20"
            name="password"
            @input="signupError = false"
            @enter="signup()"
          />
          <password-input
            v-model="signupData.repeatPassword"
            label="Powtórz hasło"
            icon="mdi-lock"
            :error="signupError"
            :maxlength="20"
            name="repeat-password"
            @input="signupError = false"
            @enter="signup()"
          />
          <v-btn
            color="success"
            @click="signup()"
          >
            ZAREJESTRUJ
          </v-btn>
          <p class="text-caption my-3">
            posiadasz już konto?
          </p>
          <v-btn
            color="primary"
            small
            link
            :to="{ name: 'Login' }"
          >
            ZALOGUJ SIĘ
          </v-btn>
        </div>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import { createUser } from '@/services/authentication_service.js'

export default {
  name: 'Signup',

  data () {
    return {
      signupData: {
        name: '',
        surname: '',
        username: '',
        email: '',
        password: '',
        repeatPassword: ''
      },
      signupError: false,
      loading: false
    }
  },

  methods: {
    signup () {
      const self = this
      self.loading = true
      if (self.validateSignupForm()) {
        createUser(self.signupData)
          .then((data) => {
            self.loading = false
            self.$router.push({ name: 'Login' })
          })
          .catch((error) => {
            self.signupError = true
            self.loading = false
          })
      } else {
        self.signupError = true
        self.loading = false
      }
    },
    validateSignupForm () {
      return this.signupData.username.trim() !== '' &&
        this.signupData.name.trim() !== '' &&
        this.signupData.surname.trim() !== '' &&
        this.signupData.email.trim() !== '' &&
        this.signupData.password.trim() !== '' &&
        this.signupData.repeatPassword !== '' &&
        this.signupData.password === this.signupData.repeatPassword
    }
  }
}
</script>
