<template>
  <n-layout has-sider class="h-screen">
    <global-sider />
    <n-layout>
      <global-header />
      <global-content />
    </n-layout>
  </n-layout>
</template>

<script setup lang="ts">
import GlobalContent from './components/GlobalContent.vue'
import GlobalHeader from './components/GlobalHeader.vue'
import GlobalSider from './components/GlobalSider.vue'
import {useTabsStore} from '@/store'
import {getFirstPath, loadAsyncRoutes} from '@/utils/router'
import {useRoute} from 'vue-router'
import {router} from '@/router'
import {v_userMenu} from '@/api'

const tabsStore = useTabsStore()
const route = useRoute()

/**
 * 从后台加载用户菜单
 */
v_userMenu()
  .then((res) => {
    loadAsyncRoutes(res.data)
    tabsStore.menu.length = 0
    tabsStore.menu.push(...res.data)
    goPage()
  })
  .catch((error) => {
    console.log(error)
    // router.push("/login")
  })

/**
 * 移除全路径匹配导向404
 */
function removeNotFound() {
  router.removeRoute('NotFound')
  router.addRoute({
    path: '/:path(.*)*',
    name: 'NotFound',
    redirect: '/404'
  })
}

/**
 * 跳转到指定页面
 */
function goPage() {
  const is = ohterSkip()
  if (!is) {
    const first = getFirstPath(tabsStore.menu)
    if (first) router.push(first)
    else router.push('/404')
  }
}

/**
 * 其他页面刷新则跳转其他页面,否则返回false
 */
function ohterSkip(): boolean {
  if (route.query && route.query.url && route.query.url != '/index') {
    removeNotFound()
    // 检查路径是否有权限
    const routers = router.getRoutes()
    const one = routers.find(({ path }) => {
      return route.query.url == path
    })
    if (one) {
      let query = JSON.parse(route.query.query as string)
      router.push({
        path: route.query.url as string,
        query: Object.keys(query).length ? query : {}
      })
    } else {
      router.push({ path: '/404', replace: true })
    }

    return true
  }
  return false
}
</script>
