import { defineStore } from 'pinia'
import { v2_login, v2_logout } from '@/api'

interface UserSotre {
  /** 用户信息 */
  token: string
  permission: string[]
}

export const useUserStore = defineStore('user-store', {
  state: (): UserSotre => ({
    token: '',
    permission: []
  }),
  actions: {
    /** 用户登陆 */
    async login(loginForm: Record<string, unknown>): Promise<boolean> {
      return await v2_login(loginForm)
        .then((res) => {
          this.token = res.data
          return true
        })
        .catch(() => {
          return false
        })
    },

    /** 用户登出 */
    async logout() {
      this.$reset()
      await v2_logout()
    }
  },
  persist: true
})
