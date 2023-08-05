import type { Router } from 'vue-router'
import { usePermissionStore, useUserStore } from '@/store'

/**
 * 路由守卫函数
 * @param router - 路由实例
 */
export function createRouterGuard(router: Router) {
  const permissionStore = usePermissionStore()
  const userStore = useUserStore()

  router.beforeEach(async (to, from, next) => {
    if (!window.isLoading) {
      // 加载启动动画
      window.isLoading = true
    }

    // 开始 loadingBar
    window.$loadingBar?.start()

    console.log('route guard start')

    // 如果路由存在,则直接放行
    if (router.hasRoute(to.name || 'NOT_NAME')) {
      next()
      return
    }

    // 下面处理路由不存在的情况

    // 没有用户令牌,跳转登陆页面
    if (!userStore.token) {
      // window.$message.warning('请先登陆!')
      next({
        path: '/login',
        query: { redirect: encodeURIComponent(to.fullPath) }
      })
      return
    }

    // 如果从后台加载的路由为空,从后台加载路由
    const { routes } = permissionStore
    if (routes && routes.length === 0) {
      // 从后台加载路由
      try {
        await permissionStore.buildAsyncRoutes()
      } catch (_e) {
        next()
        return
      }
      const redirect = decodeURIComponent((from.query.redirect || to.path) as string)
      next(to.path === redirect ? { ...to, replace: true } : { path: redirect })
      return
    }

    console.warn('正常情况不应该走到此处')
    next()
  })

  // 路由结束后操作
  router.afterEach(() => {
    // 结束 loadingBar
    window.$loadingBar?.finish()
  })
}
