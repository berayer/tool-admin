import {defineStore} from 'pinia'

interface TabsState {
  menu: AppMenu[]
}

export const useTabsStore = defineStore('tabs-store', {
  state: (): TabsState => ({
    menu: []
  }),
  actions: {
    /**
     * 获取当前菜单的上下文
     * 用户面包屑
     * @param key 当前路由的值
     * @param menus 查找数组,如果为空,则为当前系统的路由菜单
     */
    getRouteContext(key: string, menus?: AppMenu[]): AppMenu[] {
      if (!menus) menus = this.menu
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
