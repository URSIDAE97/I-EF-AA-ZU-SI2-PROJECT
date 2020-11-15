import server_api from './axios_config'

const BASE_URL = '/user'

export function authenticateUser (user) {
  return new Promise((resolve, reject) => {
    return server_api.post(`${BASE_URL}/login`, user)
      .then(response => {
        const token = response.headers['ApplicationToken']
        const h = response.request.headers
        resolve(token)
      })
      .catch(error => {
        console.log(error)
        reject(error)
      })
  })
}

export function createUser (user) {
  return new Promise((resolve, reject) => {
    return server_api.post(`${BASE_URL}/register`, user)
      .then(response => {
        resolve(response.data)
      })
      .catch(error => {
        console.log(error)
        reject(error)
      })
  })
}
