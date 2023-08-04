import type { RouteRecordRaw } from 'vue-router'
import BlankLayout from '@/layouts/blank.vue'

/**
 * 静态路由菜单
 */
export const constantRoutes: RouteRecordRaw[] = [
  {
    path: '/',
    redirect: import.meta.env.VITE_APP_BASE_URL
  },
  {
    path: '/blank',
    name: 'BlankLayout',
    component: BlankLayout,
    redirect: '/login',
    children: [
      {
        path: '/login',
        name: 'Login',
        component: () => import('@/views/_base/login/index.vue')
      },
      {
        path: '/403',
        name: 'Result403',
        component: () => import('@/views/_base/403/index.vue')
      },
      {
        path: '/404',
        name: 'Result404',
        component: () => import('@/views/_base/404/index.vue')
      },
      {
        path: '/500',
        name: 'Result500',
        component: () => import('@/views/_base/500/index.vue')
      }
    ]
  }
]
