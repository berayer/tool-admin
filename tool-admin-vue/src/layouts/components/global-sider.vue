<template>
  <n-layout-sider
    bordered
    :width="appStore.siderWidth"
    :collapsed="appStore.siderCollapse"
    :collapsed-width="appStore.siderCollapseWidth"
    collapse-mode="width"
  >
    <div class="flex h-14 px-2 py-1">
      <div
        class="flex h-full w-full items-center justify-center rounded-md bg-gray-200 shadow-md shadow-gray-300"
      >
        <n-gradient-text
          class="select-none flex-nowrap p-1 text-2xl"
          gradient="linear-gradient(90deg, red 0%, green 50%, blue 100%)"
        >
          {{ appStore.siderCollapse ? 'TA' : 'Tool Admin' }}
        </n-gradient-text>
      </div>
    </div>
    <sider-menu />
  </n-layout-sider>
</template>

<script setup lang="ts">
import SiderMenu from './sider-menu.vue'
import { useAppStore } from '@/store'

const appStore = useAppStore()
</script>
