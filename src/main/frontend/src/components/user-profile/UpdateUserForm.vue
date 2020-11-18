<template>
  <div v-if="userInfo">
    <p>
      <b>Nazwa użytkownika: </b>
      {{ user.username }}
    </p>
    <text-input
      v-model="userInfo.name"
      label="Imie"
      icon="mdi-account"
      :error="userInfoError"
      :maxlength="20"
      name="name"
      @input="userInfoError = false"
      @enter="updateUser()"
    />
    <text-input
      v-model="userInfo.surname"
      label="Nazwisko"
      icon="mdi-account"
      :error="userInfoError"
      :maxlength="20"
      name="surname"
      @input="userInfoError = false"
      @enter="updateUser()"
    />
    <text-input
      v-model="userInfo.email"
      label="Email"
      icon="mdi-email"
      :error="userInfoError"
      :maxlength="20"
      name="email"
      @input="userInfoError = false"
      @enter="updateUser()"
    />
    <v-row class="mt-2">
      <v-col>
        <v-btn
          color="success"
          @click="updateUser()"
        >
          <v-icon left>
            mdi-check-circle-outline
          </v-icon>
          AKTUALIZUJ
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
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'UpdateUserForm',

  data () {
    return {
      userInfo: null,
      userInfoError: false
    }
  },

  computed: {
    ...mapState([
      'user'
    ])
  },

  methods: {
    closeUpdateForm () {
      this.$emit('finished')
    }
  },

  mounted () {
    this.userInfo = Object.assign({}, this.user)
  }
}
</script>
