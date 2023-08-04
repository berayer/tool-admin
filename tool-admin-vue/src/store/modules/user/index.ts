import { defineStore } from 'pinia'
import { v2_login } from '@/api'

interface UserSotre {
  /** 用户信息 */
  token: string
  permission: string[]
}

export const useUserStore = defineStore('user-store', {
  state: (): UserSotre => ({
    token: 'tg_geGMABEGCtzJgx_o25NiwhzYJeJZSYb__',
    permission: []
  }),
  actions: {
    /** 用户登陆 */
    async login(loginForm: Record<string, unknown>): Promise<boolean> {
      return await v2_login(loginForm).then((res) => {
        if (res.code === 200) {
          console.log(res)

          this.token = res.data
          return true
        }
        return false
      })
    }
  }
})
