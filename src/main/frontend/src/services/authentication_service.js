import server_api from './axios_config'

export function authenticate_user (user) {
  return new Promise((resolve, reject) => {
    if (user.username === 'aaa' && user.password === 'aaa') {
      const data = {
        access_token: 'token'
      }
      resolve(data)
    } else {
      reject()
    }
    // return server_api.post('/auth/login', user)
    //   .then(response => {
    //     resolve(response.data)
    //   })
    //   .catch(error => {
    //     console.log(error)
    //     reject(error)
    //   })
  })
}