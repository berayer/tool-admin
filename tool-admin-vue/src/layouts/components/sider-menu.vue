<template>
  <n-menu
    :indent="16"
    :collapsed-width="appStore.siderCollapseWidth"
    :collapsed="appStore.siderCollapse"
    :options="menuOptions"
    :watch-props="['defaultExpandedKeys']"
    :value="route.fullPath"
    @update:value="handleUpdateValue"
  ></n-menu>
</template>

<script setup lang="ts">
import type { MenuOption } from 'naive-ui'
import MICon from '@/components/m-icon/index.vue'
import { useAppStore, usePermissionStore } from '@/store'
import { useRoute } from 'vue-router'
import { router } from '@/router'

const appStore = useAppStore()
const permissionStore = usePermissionStore()
const route = useRoute()
const menuOptions = ref<MenuOption[]>([])

const option = appMenuToMenuOption(permissionStore.routes)
menuOptions.value = option

// 递归将后台菜单转换为N-Menu
function appMenuToMenuOption(menus: AppMenu[]): MenuOption[] {
  return menus.map((item) => {
    const menu: MenuOption = {
      label: item.title,
      key: item.path,
      icon: () => h(MICon, { name: item.icon!, size: 20 })
    }
    if (item.children) {
      menu.children = appMenuToMenuOption(item.children)
    }
    return menu
  })
}

// 菜单被点击事件
function handleUpdateValue(key: string) {
  router.push(key)
}
</script>
