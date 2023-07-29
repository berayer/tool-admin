<template>
  <div class="overflow-x-hidden rounded-2xl bg-white" style="min-height: 384px">
    <!-- 表格顶部菜单栏 -->
    <div class="flex h-10 items-center bg-gray-200 px-3">
      <!-- 左侧按钮组 -->
      <div class="flex flex-1 justify-start space-x-1">
        <n-button quaternary circle :focusable="false">
          <template #icon>
            <Icon name="mdi:plus" :size="18" />
          </template>
        </n-button>

        <n-button quaternary circle :focusable="false">
          <template #icon>
            <Icon name="mdi:delete" :size="18" />
          </template>
        </n-button>

        <n-button quaternary circle :focusable="false">
          <template #icon>
            <Icon name="mdi:refresh" :size="18" />
          </template>
        </n-button>

        <n-button quaternary circle :focusable="false">
          <template #icon>
            <Icon name="mdi:magnify" :size="18" />
          </template>
        </n-button>

        <n-button quaternary circle :focusable="false">
          <template #icon>
            <Icon name="mdi:dots-vertical" :size="18" />
          </template>
        </n-button>
      </div>
      <!-- 右侧菜单组 -->
      <div class="flex flex-1 items-center justify-end space-x-2">
        <span class="text-xs">行: {{ config.total.value }}</span>
        <n-divider vertical />

        <n-button quaternary circle :focusable="false">
          <template #icon>
            <Icon name="mdi:view-grid-outline" :size="18" />
          </template>
        </n-button>
      </div>
    </div>
    <!-- 数据表格 -->
    <n-data-table
      :columns="config.columns"
      :data="config.data.value"
      :row-key="(row:any) => row.id"
      max-height="720px"
      :on-scroll="scrollTo"
      :loading="config.loading.value"
    >
    </n-data-table>
  </div>
</template>

<script setup lang="ts">
import { MTableConfig } from '@/utils/MTable'
import { debounce } from 'lodash'

const prop = defineProps<{
  config: MTableConfig
}>()

/**
 * 滚动加载
 * 当移动到底部时,自动加载下一页数据
 */
const scrollTo = debounce((e: Event) => {
  const target = e.target as HTMLElement
  if (target.scrollHeight - target.offsetHeight - target.scrollTop < 100) {
    prop.config.loadData()
  }
}, 200)
</script>
