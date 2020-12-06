import { jwtDecode } from 'jwt-js-decode'
import { getAuthToken } from '@/services/local_storage_service'
import { getCategories, addCategory, editCategory, deleteCategory } from '@/services/category_service'

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
      .then((data) => {
        commit('DELETE_CATEGORY', id)
      })
  }
}
