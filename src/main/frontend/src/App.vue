<template>
  <v-app id="app">
    <nav-menu />

    <app-bar />

    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
import NavMenu from '@/components/app/NavMenu'
import AppBar from '@/components/app/AppBar'

export default {
  components: {
    NavMenu,
    AppBar
  }
}
</script>
