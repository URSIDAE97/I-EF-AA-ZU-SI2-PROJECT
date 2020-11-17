import Vue from 'vue'
import VueRouter from 'vue-router'
import { getAuthToken } from '@/services/local_storage_service.js'

import Dashboard from '@/views/Dashboard'
import Questionnaires from '@/views/Questionnaires'
import MyQuestionnaires from '@/views/MyQuestionnaires'
import AdminPanel from '@/views/AdminPanel'
import EditQuestionnaire from '@/views/EditQuestionnaire'
import Login from '@/views/Login'
import Signup from '@/views/Signup'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Dashboard',
    component: Dashboard,
    meta: {
      title: 'dashboard'
    }
  },
  {
    path: '/questionnaires',
    name: 'Questionnaires',
    component: Questionnaires,
    meta: {
      title: 'ankiety'
    }
  },
  {
    path: '/my-questionnaires',
    name: 'MyQuestionnaires',
    component: MyQuestionnaires,
    meta: {
      title: 'moje ankiety'
    }
  },
  {
    path: '/admin-panel',
    name: 'AdminPanel',
    component: AdminPanel,
    meta: {
      title: 'panel administratora'
    }
  },
  {
    path: '/edit-questionnaire',
    name: 'EditQuestionnaire',
    component: EditQuestionnaire,
    meta: {
      title: 'edycja ankiety'
    }
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
    meta: {
      title: 'logowanie'
    }
  },
  {
    path: '/signup',
    name: 'Signup',
    component: Signup,
    meta: {
      title: 'rejestracja'
    }
  }
]

const router = new VueRouter({
  routes
})

router.beforeEach((to, from, next) => {
  if (!['Login', 'Signup'].includes(to.name) && getAuthToken() === null) {
    next({ name: 'Login' })
  } else if (['Login', 'Signup'].includes(to.name) && getAuthToken() !== null) {
    next(from)
  } else {
    next()
  }
})

router.afterEach((to) => {
  document.title = 'ANKIETYZACJA - ' + to.meta.title
})

export default router
