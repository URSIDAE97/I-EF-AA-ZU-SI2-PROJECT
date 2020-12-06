import server_api from './axios_config'

const BASE_URL = '/v1'

export function getCategories () {
  return new Promise((resolve, reject) => {
    return server_api.get(`${BASE_URL}/categories`)
      .then(response => {
        resolve(response.data)
      })
      .catch(error => {
        console.error(error)
        reject(error)
      })
  })
}

export function addCategory (category) {
  return new Promise((resolve, reject) => {
    return server_api.post(`${BASE_URL}/category`, category)
      .then((response) => {
        resolve(response.data)
      })
      .catch((error) => {
        console.error(error)
        reject(error)
      })
  })
}

export function editCategory (category) {
  return new Promise((resolve, reject) => {
    return server_api.post(`${BASE_URL}/category/${category.id}`, category)
      .then((response) => {
        resolve(response.data)
      })
      .catch((error) => {
        console.error(error)
        reject(error)
      })
  })
}

export function deleteCategory (id) {
  return new Promise((resolve, reject) => {
    return server_api.delete(`${BASE_URL}/category/${id}`)
      .then((response) => {
        resolve(response.data)
      })
      .catch((error) => {
        console.error(error)
        reject(error)
      })
  })
}
