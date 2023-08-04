<template>
  <n-breadcrumb>
    <n-breadcrumb-item v-for="item in breadcrumbs" :key="item.path">
      <n-dropdown
        v-if="item.children"
        :options="genOptions(item.children)"
        @select="dropdownSelect"
      >
        <span> <m-icon :name="item.icon!" :size="18" /> {{ item.title }} </span>
      </n-dropdown>

      <span v-else><m-icon :name="item.icon!" :size="18" /> {{ item.title }}</span>
    </n-breadcrumb-item>
  </n-breadcrumb>
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router'
import { usePermissionStore } from '@/store'
import type { DropdownOption } from 'naive-ui'
import MIcon from '@/components/m-icon/index.vue'
import { router } from '@/router'

const route = useRoute()
const permissionStore = usePermissionStore()

const breadcrumbs = computed(() => {
  return permissionStore.getRouteContext(route.fullPath)
})

function genOptions(children: AppMenu[]): DropdownOption[] {
  return children.map((item) => {
    return {
      label: item.title,
      key: item.path,
      icon: () => h(MIcon, { name: item.icon!, size: 18 })
    }
  })
}

function dropdownSelect(key: string) {
  router.push(key)
}
</script>
