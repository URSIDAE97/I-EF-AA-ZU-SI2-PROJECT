import { jwtDecode } from 'jwt-js-decode'
import { getAuthToken } from '@/services/local_storage_service'

export default {
  setUserInfo ({ commit }) {
    var user = null
    var auth_token = getAuthToken()
    if (auth_token) {
      user = {
        username: 'Jan Kowalski',
        email: 'jank@gmail.com'
      }
      // var jwt = jwtDecode(auth_token)
      // user = jwt.payload.identity
    }
    commit('SET_USER_INFO', user)
  }
}
