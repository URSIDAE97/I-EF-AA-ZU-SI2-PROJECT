import server_api from './axios_config'

const BASE_URL = '/v1'

export function getQuestionnaires () {
  return new Promise((resolve, reject) => {
    return server_api.get(`${BASE_URL}/questionnaires`)
      .then(response => {
        resolve(response.data)
      })
      .catch(error => {
        console.error(error)
        reject(error)
      })
  })
}

export function addQuestionnaire (questionnaire) {
  return new Promise((resolve, reject) => {
    return server_api.post(`${BASE_URL}/questionnaire`, questionnaire)
      .then(response => {
        resolve(response.data)
      })
      .catch(error => {
        console.error(error)
        reject(error)
      })
  })
}

export function editQuestionnaire (questionnaire) {
  return new Promise((resolve, reject) => {
    return server_api.post(`${BASE_URL}/questionnaire/${questionnaire.id}`, questionnaire)
      .then(response => {
        resolve(response.data)
      })
      .catch(error => {
        console.error(error)
        reject(error)
      })
  })
}

export function deleteQuestionnaire (id) {
  return new Promise((resolve, reject) => {
    return server_api.delete(`${BASE_URL}/questionnaire/${id}`)
      .then(response => {
        resolve(response.data)
      })
      .catch(error => {
        console.error(error)
        reject(error)
      })
  })
}

export function activateQuestionnaire (id) {
  return new Promise((resolve, reject) => {
    return server_api.get(`${BASE_URL}/questionnaire/activate/${id}`)
      .then(response => {
        resolve(response.data)
      })
      .catch(error => {
        console.error(error)
        reject(error)
      })
  })
}
