<template>
  <div class="overflow-x-hidden rounded-2xl bg-white" style="min-height: 384px">
    <!-- 表格顶部菜单栏 -->
    <div class="flex h-10 items-center bg-gray-200 px-3">
      <!-- 左侧按钮组 -->
      <div class="flex flex-1 justify-start space-x-1">
        <!-- 新增按钮 -->
        <n-button quaternary circle :focusable="false" @click="$emit('addClick')">
          <template #icon>
            <Icon name="mdi:plus" :size="18" />
          </template>
        </n-button>
        <!-- 删除按钮 -->
        <n-button quaternary circle :focusable="false">
          <template #icon>
            <Icon name="mdi:delete" :size="18" />
          </template>
        </n-button>
        <!-- 刷新按钮 -->
        <n-button quaternary circle :focusable="false">
          <template #icon>
            <Icon name="mdi:refresh" :size="18" />
          </template>
        </n-button>
        <!-- 搜索按钮 -->
        <n-button quaternary circle :focusable="false">
          <template #icon>
            <Icon name="mdi:magnify" :size="18" />
          </template>
        </n-button>
        <!-- 更多菜单 -->
        <n-button quaternary circle :focusable="false">
          <template #icon>
            <Icon name="mdi:dots-vertical" :size="18" />
          </template>
        </n-button>
      </div>
      <!-- 右侧菜单组 -->
      <div class="flex flex-1 items-center justify-end space-x-2">
        <!-- 总行数 -->
        <span class="text-xs">行: {{ data.length }}</span>
        <!-- 分割线 -->
        <n-divider vertical />
        <!-- 表格列设置 -->
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
                <div v-if="element.key" class="flex w-full items-center justify-between py-2">
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
    <n-data-table
      bordered
      :on-scroll="scrollTo"
      max-height="720px"
      v-bind="$.attrs"
      :data="data"
      :columns="(dataTableColumns as any)"
      :single-line="false"
      striped
      :loading="state.loading"
    >
    </n-data-table>
  </div>
</template>

<script setup lang="ts">
import { DataTableProps, NCheckbox } from 'naive-ui'
import Icon from '../Icon.vue'
import draggable from 'vuedraggable'
import { debounce } from 'lodash'
import http from '@/utils/request'

defineOptions({
  name: 'MTable'
})

// 列配置数据,动态修改
const columnsOptions = ref<anyObj[]>([])
const dataTableColumns = ref<anyObj[]>([])
const data = ref<anyObj[]>([])
const attrs = useAttrs()
const state = reactive({
  loading: false
})

/**
 * 将传进来的列配置添加到columnsOptions并且填写额外选项
 */
const arrs = attrs.columns as anyObj[]
arrs.forEach((item) => {
  item.show = true
  columnsOptions.value.push(item)
  dataTableColumns.value.push(item)
})
/**
 * 监听列配置数组,发生改变时重新生成列
 */
watch(
  columnsOptions,
  () => {
    dataTableColumns.value = columnsOptions.value.filter((item) => !item.show === false)
  },
  { deep: true }
)

/**
 * @description 继承类型会导致TS报错
 * @link https://github.com/tusen-ai/naive-ui/issues/4810
 */
interface Props extends /* @vue-ignore */ DataTableProps {
  page?: boolean
  baseUrl: string
}

defineEmits(['addClick'])
const prop = withDefaults(defineProps<Props>(), {
  page: false
})

// 从后台加载数据
state.loading = true
http({
  url: prop.baseUrl + '/search'
})
  .then((res) => {
    data.value.push(...res.data)
    console.log(res)
  })
  .finally(() => {
    state.loading = false
  })

/**
 * 滚动加载
 * 当移动到底部时,自动加载下一页数据
 */
const scrollTo = debounce((e: Event) => {
  const target = e.target as HTMLElement
  if (target.scrollHeight - target.offsetHeight - target.scrollTop < 100) {
    // prop.config.loadData()
  }
}, 200)
</script>
