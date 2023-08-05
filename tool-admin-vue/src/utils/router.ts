import { router } from '@/router'
import HomeLayout from '@/layouts/index.vue'

/**
 * 404页面,加载完后台菜单之后注册到路由中
 */
const NOT_FOUND_ROUTE = {
  path: '/:w+',
  redirect: '/404'
}

const HOME_LAYOUT = {
  path: '/index',
  name: 'HomeLayout',
  component: HomeLayout,
  redirect: '/404',
  children: []
}

/**
 * 异步加载路由
 * @param menus 后台菜单数组
 */
export function loadAsyncRoutes(menus: AppMenu[]) {
  const views = import.meta.glob('/src/views/**/index.vue')
  const redirect = getFirstPath(menus)
  if (redirect) HOME_LAYOUT.redirect = redirect
  router.addRoute(HOME_LAYOUT)
  addRoutes(menus, views)
  router.addRoute(NOT_FOUND_ROUTE)
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
      const component = views['/src/views' + menus[i].path + '/index.vue']

      if (component) {
        router.addRoute('HomeLayout', {
          path: menus[i].path,
          name: menus[i].name,
          component: component
        })
        console.log(`loadding route: ${menus[i].path}`)
      } else {
        console.warn(`can not find vue page: /src/views${menus[i].path}/index.vue`)
      }
    }
  }
}

/**
 * 获取菜单数组中第一个路由路径
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
