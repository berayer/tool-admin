import { defineStore } from 'pinia'
import { v2_userMenu } from '@/api'
import { loadAsyncRoutes } from '@/utils/router'

type PermissionStore = {
  routes: AppMenu[]
}

export const usePermissionStore = defineStore('permission-store', {
  state: (): PermissionStore => ({
    routes: []
  }),
  actions: {
    /** 用户登陆 */
    async buildAsyncRoutes() {
      await v2_userMenu().then((res) => {
        this.routes = res.data
      })
      loadAsyncRoutes(this.routes)
    },
    
    /**
     * 获取当前菜单的上下文
     * 用户面包屑
     * @param key 当前路由的值
     * @param menus 查找数组,如果为空,则为当前系统的路由菜单
     */
    getRouteContext(key: string, menus?: AppMenu[]): AppMenu[] {
      if (!menus) menus = this.routes
      let res: AppMenu[] = []
      for (let i = 0; i < menus.length; i++) {
        if (menus[i].children && menus[i].children!.length > 0) {
          const children = this.getRouteContext(key, menus[i].children)
          if (children && children.length > 0) {
            res = [menus[i], ...children]
            break
          }
        } else if (menus[i].path == key) {
          res = [menus[i]]
          break
        }
      }
      return res
    }
  }
})
