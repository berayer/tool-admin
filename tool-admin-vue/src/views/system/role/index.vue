<template>
  <m-table base-url="/role" :columns="columns" :row-key="(row) => row.id" />
</template>

<script setup lang="ts">
import type { DataTableColumns } from 'naive-ui'
import { NButton } from 'naive-ui'

const state = reactive({
  editModal: false,
  editType: 'add',
  updateData: {}
})
const columns = ref<DataTableColumns>([
  {
    type: 'selection'
  },
  {
    key: 'name',
    title: '角色名称'
  },
  {
    key: 'createBy',
    title: '创建人'
  },
  {
    key: 'createTime',
    title: '创建时间'
  },
  {
    key: 'updateBy',
    title: '最后修改人'
  },
  {
    key: 'updateTime',
    title: '最后修改时间'
  },
  {
    key: 'action',
    title: '操作',
    width: 120,
    align: 'center',
    render: () =>
      h('div', { class: 'space-x-4' }, [
        h(NButton, { type: 'error', text: true }, { default: () => '删除' }),
        h(
          NButton,
          {
            type: 'warning',
            text: true,
            onClick: () => {
              state.editModal = true
              state.editType = 'edit'
            }
          },
          { default: () => '编辑' }
        )
      ])
  }
])
</script>
