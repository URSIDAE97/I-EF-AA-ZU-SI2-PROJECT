import Vue from 'vue'
import VueRouter from 'vue-router'
import Dashboard from '@/views/Dashboard'
import Polls from '@/views/Polls'
import MyPolls from '@/views/MyPolls'
import AdminPanel from '@/views/AdminPanel'
import EditPoll from '@/views/EditPoll'

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
  },
  {
    path: '/admin-panel',
    name: 'AdminPanel',
    component: AdminPanel
  },
  {
    path: '/edit-poll',
    name: 'EditPoll',
    component: EditPoll
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
