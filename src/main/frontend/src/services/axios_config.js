import axios from 'axios'
import { getAuthToken, setAuthToken } from '@/services/local_storage_service'

const server_api = axios.create({
  baseURL: '/api',
  headers: {
    'Content-Type': 'application/json'
  }
})

server_api.interceptors.request.use((config) => {
  const token = getAuthToken()
  if (token) {
    config.headers.common.applicationtoken = token
  }
  return config
})

server_api.interceptors.response.use((response) => {
  const token = response.headers['applicationtoken']
  if (token) {
    setAuthToken(token)
  }
  return response
})

export default server_api
