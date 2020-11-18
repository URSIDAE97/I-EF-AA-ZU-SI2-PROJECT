<template>
  <v-tabs
    id="admin-panel"
    class="ma-0 pa-5"
  >
    <v-tab>Kategorie</v-tab>
    <v-tab>Użytkownicy</v-tab>

    <v-tab-item>
      <categories-setup />
    </v-tab-item>

    <v-tab-item>
      <manage-users />
    </v-tab-item>
  </v-tabs>
</template>

<script>
import CategoriesSetup from '@/components/admin-panel/CategoriesSetup'
import ManageUsers from '@/components/admin-panel/ManageUsers'

export default {
  name: 'AdminPanel',

  components: {
    CategoriesSetup,
    ManageUsers
  }
}
</script>