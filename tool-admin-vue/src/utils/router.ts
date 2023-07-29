import { router } from '@/router'

/**
 * 异步加载路由
 * @param menus 后台菜单数组
 */
export function loadAsyncRoutes(menus: AppMenu[]) {
  const views = import.meta.glob('/src/views/**/index.vue')
  addRoutes(menus, views)
}

/**
 * 递归向vue-router中添加路由
 * @param menus 后台返回的路由菜单
 * @param views 视图组件数组
 */
function addRoutes(menus: AppMenu[], views: Record<string, () => Promise<unknown>>) {
  for (const i in menus) {
    if (menus[i].children && menus[i].children!.length > 0) {
      addRoutes(menus[i].children!, views)
    } else {
      router.addRoute('HomeLayout', {
        path: menus[i].path,
        component: views['/src/views' + menus[i].path + '/index.vue']
      })
      console.log(`loadding route: ${menus[i].path}`)
    }
  }
}

/**
 * 获取菜单数组中第一个路由
 * @param menus 菜单数组
 */
export function getFirstPath(menus: AppMenu[]): string | undefined {
  for (const i in menus) {
    if (menus[i].children && menus[i].children!.length > 0) {
      return getFirstPath(menus[i].children!)
    } else {
      return menus[i].path
    }
  }
}
