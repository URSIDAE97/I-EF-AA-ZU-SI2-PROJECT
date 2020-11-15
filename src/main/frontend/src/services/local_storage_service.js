const AUTH_TOKEN = 'auth-token'

export function setAuthToken (token) {
  localStorage.setItem(AUTH_TOKEN, token)
}

export function getAuthToken () {
  return localStorage.getItem(AUTH_TOKEN)
}

export function clearAuthToken () {
  localStorage.removeItem(AUTH_TOKEN)
}