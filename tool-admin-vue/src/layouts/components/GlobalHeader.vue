<template>
  <n-layout-header bordered class="flex h-14 justify-between">
    <div class="flex h-full items-center space-x-2">
      <div
        class="flex h-full cursor-pointer items-center px-3 hover:bg-gray-100"
        :onclick="changeCollapse"
      >
        <icon v-if="appStore.siderCollapse" name="mdi:menu-close" :size="20" />
        <icon v-else name="mdi:menu-open" :size="20" />
      </div>
      <header-breadcrumb />
    </div>
    <div>afc</div>
  </n-layout-header>
</template>

<script setup lang="ts">
import { useAppStore } from '@/store'
import HeaderBreadcrumb from './HeaderBreadcrumb.vue'

const appStore = useAppStore()
// 切换侧边栏展开状态
function changeCollapse() {
  appStore.siderCollapse = !appStore.siderCollapse
}
</script>
