<template>
  <n-modal preset="card" :show="show" :on-update-show="() => $emit('update:show')" title="新增菜单" style="width: 384px" clos>
    <n-form class="px-2">
      <n-form-item label="标题">
        <n-input></n-input>
      </n-form-item>

      <n-form-item label="路径">
        <n-input></n-input>
      </n-form-item>

      <n-form-item label="名称">
        <n-input></n-input>
      </n-form-item>

      <n-form-item label="菜单类型">
        <n-select v-model:value="data.type" :options="typeOptions" />
      </n-form-item>

      <n-form-item label="图标">
        <n-input></n-input>
        <n-button tag="a" target="_blank" href="https://icon-sets.iconify.design/carbon/">去选择</n-button>
      </n-form-item>

      <n-form-item :show-label="false" :show-feedback="false">
        <div class="flex w-full justify-end space-x-4">
          <n-button >取消</n-button>
          <n-button type="success">保存</n-button>
        </div>
      </n-form-item>
    </n-form>
  </n-modal>
</template>

<script setup lang="ts">
import { SelectOption } from 'naive-ui'

defineProps<{
  show: boolean
}>()

defineEmits(['update:show'])

const data = reactive<{
  type: 1 | 2 | 3 | undefined
}>({
  type: undefined
})

const typeOptions: SelectOption[] = [
  {
    label: '路由',
    value: 1
  },
  {
    label: '外链接',
    value: 2
  },
  {
    label: 'ifarme',
    value: 3
  }
]
</script>
