import Vue from 'vue'
import VueRouter from 'vue-router'
import Dashboard from '@/views/Dashboard'
import Polls from '@/views/Polls'
import MyPolls from '@/views/MyPolls'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Dashboard',
    component: Dashboard
  },
  {
    path: '/polls',
    name: 'Polls',
    component: Polls
  },
  {
    path: '/my-polls',
    name: 'MyPolls',
    component: MyPolls
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
