<template>
  <v-form>
    <v-container class="pa-3 ma-0">
      <v-row style="width: 500px;">
        <v-col>
          <password-input
            v-model="changePasswordData.oldPassword"
            label="Stare hasło"
            icon="mdi-lock"
            :error="changePasswordError"
            :maxlength="20"
            name="old-password"
            @input="changePasswordError = false"
            @enter="changePassword()"
          />
          <password-input
            v-model="changePasswordData.newPassword"
            label="Nowe hasło"
            icon="mdi-lock"
            :error="changePasswordError"
            :maxlength="20"
            name="new-password"
            @input="changePasswordError = false"
            @enter="changePassword()"
          />
          <password-input
            v-model="changePasswordData.repeatNewPassword"
            label="Powtórz nowe hasło"
            icon="mdi-lock"
            :error="changePasswordError"
            :maxlength="20"
            name="repeat-new-password"
            @input="changePasswordError = false"
            @enter="changePassword()"
          />
          <v-btn
            color="success"
            @click="changePassword()"
            class="mt-2"
          >
            <v-icon left>
              mdi-check-circle-outline
            </v-icon>
            ZMIEŃ HASŁO
          </v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-form>
</template>

<script>
export default {
  name: 'ChangePasswordForm',

  data () {
    return {
      changePasswordData: {
        oldPassword: '',
        newPassword: '',
        repeatNewPassword: ''
      },
      changePasswordError: false
    }
  },

  method: {
    changePassword () {

    }
  }
}
</script>
