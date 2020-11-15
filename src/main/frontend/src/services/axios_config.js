import axios from 'axios'

const server_api = axios.create({
  baseURL: 'http://localhost:8080/api',
  headers: {
    'Content-Type': 'application/json',
    'Access-Control-Expose-Headers': 'ApplicationToken'
  }
})

export default server_api
