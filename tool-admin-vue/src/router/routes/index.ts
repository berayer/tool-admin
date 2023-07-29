import type { RouteRecordRaw } from 'vue-router'

/**
 * 静态路由菜单
 */
export const constantRoutes: RouteRecordRaw[] = [
  {
    path: '/',
    redirect: '/index'
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/_base/login/index.vue')
  },
  {
    path: '/index',
    name: 'HomeLayout',
    component: () => import('@/layouts/HomeLayout.vue'),
    children: []
  },
  {
    path: '/403',
    component: () => import('@/views/_base/403/index.vue')
  },
  {
    path: '/404',
    component: () => import('@/views/_base/404/index.vue')
  },
  {
    path: '/500',
    component: () => import('@/views/_base/500/index.vue')
  },
  {
    path: '/:path(.*)*',
    name: 'NotFound',
    redirect: (to) => {
      return {
        name: 'HomeLayout',
        /** @url https://github.com/vuejs/router/issues/1617 解决警告报错 */
        params: {},
        query: { url: to.path, query: JSON.stringify(to.query) }
      }
    }
  }
]
