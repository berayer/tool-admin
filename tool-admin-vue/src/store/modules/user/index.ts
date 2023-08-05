import { defineStore } from 'pinia'
import { v2_login } from '@/api'

interface UserSotre {
  /** 用户信息 */
  token: string
  permission: string[]
}

export const useUserStore = defineStore('user-store', {
  state: (): UserSotre => ({
    token: '2z_O5ENOfdIkiQxCg_So8VtFUTH86zuxuD__',
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
    }
  }
})
