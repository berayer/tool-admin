<template>
  <n-breadcrumb>
    <n-breadcrumb-item v-for="item in breadcrumbs" :key="item.path">
      <n-dropdown
        v-if="item.children"
        :options="genOptions(item.children)"
        @select="dropdownSelect"
      >
        <span> <Icon :name="item.icon!" :size="18" /> {{ item.name }} </span>
      </n-dropdown>

      <span v-else><Icon :name="item.icon!" :size="18" /> {{ item.name }}</span>
    </n-breadcrumb-item>
  </n-breadcrumb>
</template>

<script setup lang="ts">
import {useRoute} from 'vue-router'
import {useTabsStore} from '@/store'
import type {DropdownOption} from 'naive-ui'
import Icon from '@/components/Icon.vue'
import {router} from '@/router'

const route = useRoute()
const tabsStore = useTabsStore()

const breadcrumbs = computed(() => {
  return tabsStore.getRouteContext(route.fullPath)
})

function genOptions(children: AppMenu[]): DropdownOption[] {
  return children.map((item) => {
    return {
      label: item.name,
      key: item.path,
      icon: () => h(Icon, { name: item.icon!, size: 18 })
    }
  })
}

function dropdownSelect(key: string) {
  router.push(key)
}
</script>
