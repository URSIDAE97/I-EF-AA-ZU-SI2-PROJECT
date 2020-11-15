<template>
  <v-app id="app">
    <nav-menu v-if="user" />

    <app-bar v-if="user" />

    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
import Vue from 'vue'
import NavMenu from '@/components/app/NavMenu'
import AppBar from '@/components/app/AppBar'
import { mapState, mapActions } from 'vuex'

/* ----------------- */
/* global components */
/* ----------------- */
const TextInput = () => import(/* webpackChunkName: 'inputs' */ '@/components/common/inputs/TextInput')
const PasswordInput = () => import(/* webpackChunkName: 'inputs' */ '@/components/common/inputs/PasswordInput')

Vue.component('text-input', TextInput)
Vue.component('password-input', PasswordInput)

export default {
  components: {
    NavMenu,
    AppBar
  },

  computed: {
    ...mapState([
      'user'
    ])
  },

  methods: {
    ...mapActions([
      'setUserInfo'
    ]),
  },

  created () {
    // check if loged in and set info about user
    this.setUserInfo()
  },
}
</script>

<style lang="scss">
/* ------- */
/* customs */
/* ------- */
@import './assets/scss/app-customs.scss';
@import './assets/scss/vuetify-customs.scss';
/* ---------- */
/* scrollbars */
/* ---------- */
@import './assets/css/scrollbar.css';
</style>
