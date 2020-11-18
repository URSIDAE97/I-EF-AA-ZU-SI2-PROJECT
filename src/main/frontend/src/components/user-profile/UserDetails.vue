<template>
  <v-form id="user-details">
    <v-container class="pa-3 ma-0">
      <v-row style="width: 500px;">
        <v-col>
          <!-- DETAILS DISPLAY -->
          <div v-if="!editing">
            <p>
              <b>Nazwa użytkownika: </b>
              {{ user. username }}
            </p>
            <p>
              <b>Imie: </b>
              {{ user.name }}
            </p>
            <p>
              <b>Nazwisko: </b>
              {{ user.surname }}
            </p>
            <p>
              <b>Email: </b>
              {{ user.email }}
            </p>

            <v-btn
              class="mt-2"
              color="primary"
              @click="editing = true"
            >
              <v-icon left>
                mdi-pencil
              </v-icon>
              EDYTUJ
            </v-btn>
          </div>

          <!-- EDIT FORM -->
          <div v-else>
            <update-user-form
              @finished="editing = false"
            />
          </div>
        </v-col>
      </v-row>
    </v-container>
  </v-form>
</template>

<script>
import UpdateUserForm from '@/components/user-profile/UpdateUserForm'
import { mapState } from 'vuex'

export default {
  name: 'UserDetails',

  components: {
    UpdateUserForm
  },

  data () {
    return {
      editing: false
    }
  },

  computed: {
    ...mapState([
      'user'
    ])
  }
}
</script>
