<template>
  <n-layout-sider
    bordered
    :width="appStore.siderWidth"
    :collapsed="appStore.siderCollapse"
    :collapsed-width="appStore.siderCollapseWidth"
    collapse-mode="width"
  >
    <div class="flex h-14 items-center justify-center">App Logo</div>
    <sider-menu />
  </n-layout-sider>
</template>

<script setup lang="ts">
import SiderMenu from './SiderMenu.vue'
import { useAppStore } from '@/store'

const appStore = useAppStore()
</script>
