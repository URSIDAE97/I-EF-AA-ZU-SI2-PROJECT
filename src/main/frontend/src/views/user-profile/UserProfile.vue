<template>
  <v-tabs
    id="user-profile"
    class="ma-0 pa-5"
  >
    <v-tab>Dane użytkownika</v-tab>
    <v-tab>Zmiana hasła</v-tab>
    <v-tab>Statystyki</v-tab>

    <v-tab-item>
      <user-details />
    </v-tab-item>

    <v-tab-item>
      <change-password-form />
    </v-tab-item>

    <v-tab-item>
      <user-statistics />
    </v-tab-item>
  </v-tabs>
</template>

<script>
import UserDetails from '@/components/user-profile/UserDetails'
import ChangePasswordForm from '@/components/user-profile/ChangePasswordForm'
import UserStatistics from '@/components/user-profile/UserStatistics'

export default {
  name: 'UserProfile',

  components: {
    UserDetails,
    ChangePasswordForm,
    UserStatistics
  }
}
</script>
