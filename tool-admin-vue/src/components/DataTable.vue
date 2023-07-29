<template>
  <div class="overflow-x-hidden rounded-2xl bg-white" style="min-height: 384px">
    <!-- 表格顶部菜单栏 -->
    <div class="flex h-10 items-center bg-gray-200 px-3">
      <!-- 左侧按钮组 -->
      <div class="flex flex-1 justify-start space-x-1">
        <n-button quaternary circle :focusable="false" @click="$emit('addClick')">
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
        <span class="text-xs">行: {{ data.length }}</span>
        <n-divider vertical />

        <n-popover trigger="click" placement="bottom" raw :show-arrow="false" style="z-index: 999">
          <template #trigger>
            <n-button quaternary circle :focusable="false">
              <template #icon>
                <Icon name="mdi:view-grid-outline" :size="18" />
              </template>
            </n-button>
          </template>
          <div class="bg-white" style="min-width: 156px">
            <draggable
              v-model="columnsOptions"
              class="min-w-fit px-2"
              v-bind="{
                animation: 200,
                group: 'description',
                disabled: false,
                ghostClass: 'ghost'
              }"
              :component-data="{
                tag: 'ul',
                type: 'transition-group',
                name: 'flip-list'
              }"
              item-key="key"
              handle=".colMove"
            >
              <template #item="{ element }">
                <div class="flex w-full items-center justify-between py-2">
                  <n-checkbox v-model:checked="element.show" class="mr-4">
                    <span>{{ element.title }}</span>
                  </n-checkbox>
                  <Icon name="mdi:dots-grid" :size="18" class="colMove cursor-move" />
                </div>
              </template>
            </draggable>
          </div>
        </n-popover>
      </div>
    </div>
    <!-- 数据表格 -->
    <n-data-table v-bind="$attrs"> </n-data-table>
  </div>
</template>

<script setup lang="ts">
import { DataTableProps, NCheckbox } from 'naive-ui'
import { useAttrs } from 'vue'
import Icon from './Icon.vue'
import draggable from 'vuedraggable'

/**
 * @description 继承类型会导致TS报错
 * @link https://github.com/tusen-ai/naive-ui/issues/4810
 */
interface Props extends /* @vue-ignore */ DataTableProps {
  onDeleteSelect?: () => void
}

defineProps<Props>()
defineEmits<{
  addClick: []
}>()

const attrs = useAttrs()
// eslint-disable-next-line @typescript-eslint/no-explicit-any
const data = (attrs.data as any[]) || []
const columns = attrs.columns as any[]
const columnsOptions = ref<any[]>([])
for (let i = 0; i < columns.length; i++) {
  if (columns[i].key) {
    columnsOptions.value.push({
      key: columns[i].key,
      title: columns[i].title,
      show: true
    })
  }
}
</script>
