<template>
  <data-table :columns="columns" :data="datas" :row-key="(row) => row.id" @add-click="addClick" />
  <AddOrEdit v-model:show="state.editModal" :type="(state.editType as any)" />
</template>

<script setup lang="ts">
import type { DataTableColumns } from 'naive-ui'
import { NButton } from 'naive-ui'
import AddOrEdit from './AddOrEdit.vue'

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
const datas = ref<anyObj[]>([
  {
    id: 1,
    name: '管理员',
    createBy: 'system',
    createTime: '2023-07-06 12:59:36'
  },
  {
    id: 2,
    name: '普通用户',
    createBy: 'system',
    createTime: '2023-07-06 12:59:36'
  }
])
function addClick() {
  state.editModal = true
  state.editType = 'add'
}
</script>
