import { jwtDecode } from 'jwt-js-decode'
import { getAuthToken } from '@/services/local_storage_service'
import { getCategories, addCategory, editCategory, deleteCategory } from '@/services/category_service'
import { getQuestionnaires, addQuestionnaire, editQuestionnaire, deleteQuestionnaire, activateQuestionnaire } from '@/services/questionnaires_service'

export default {
  setUserInfo ({ commit }) {
    var user = null
    var auth_token = getAuthToken()
    if (auth_token) {
      const token = auth_token.split(' ')[1]
      var jwt = jwtDecode(token)
      user = jwt.payload.identity
    }
    commit('SET_USER_INFO', user)
  },

  getCategories ({ commit }) {
    return getCategories()
      .then((data) => {
        commit('SET_CATEGORIES', data)
      })
  },

  addCategory ({ commit }, category) {
    return addCategory(category)
      .then((data) => {
        commit('SET_CATEGORY', data)
      })
  },

  editCategory ({ commit }, category) {
    return editCategory(category)
      .then((data) => {
        commit('SET_CATEGORY', data)
      })
  },

  deleteCategory ({ commit }, id) {
    deleteCategory(id)
      .then(() => {
        commit('DELETE_CATEGORY', id)
      })
  },

  getQuestionnaires ({ commit }) {
    return getQuestionnaires()
      .then((data) => {
        commit('SET_QUESTIONNAIRES', data)
      })
  },

  addQuestionnaire ({ commit }, questionnaire) {
    return addQuestionnaire(questionnaire)
      .then((data) => {
        commit('SET_QUESTIONNAIRE', data)
      })
  },

  editQuestionnaire ({ commit }, questionnaire) {
    return editQuestionnaire(questionnaire)
      .then((data) => {
        commit('SET_QUESTIONNAIRE', data)
      })
  },

  deleteQuestionnaire ({ commit }, id) {
    deleteQuestionnaire(id)
      .then(() => {
        commit('DELETE_QUESTIONNAIRE', id)
      })
  },

  activateQuestionnaire ({ commit }, id) {
    activateQuestionnaire(id)
      .then((data) => {
        commit('SET_QUESTIONNAIRE', data)
      })
  }
}
