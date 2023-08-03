<template>
  <n-icon v-bind="prop">
    <iconify :icon="name" />
  </n-icon>
</template>

<script setup lang="ts">
import { Icon as iconify } from '@iconify/vue'

defineOptions({
  name: 'MIcon'
})

interface Props {
  name: string // 图标名称
  size?: number | string // 图标大小
  color?: string // 图标颜色
  depth?: 1 | 2 | 3 | 4 | 5 // 图标深度
}

const prop = defineProps<Props>()
</script>
