import { defineStore } from 'pinia'

interface AppState {
  token: string
}

export const useAuthStore = defineStore('auth-store', {
  state: (): AppState => ({
    token: ''
  })
})
