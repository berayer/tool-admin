<template>
  <m-table base-url="/user" :columns="columns" :row-key="(i) => i.id" @add-click="addClick" />
  <add-form ref="addForm" />
</template>

<script setup lang="ts">
import type { DataTableColumns } from 'naive-ui'
import { NButton } from 'naive-ui'
import AddForm from './AddForm.vue'

const addForm = ref<typeof AddForm | null>()
// 表格列配置
const columns: DataTableColumns = [
  {
    type: 'selection',
    width: 40,
    align: 'center'
  },
  {
    title: '序号',
    key: 'no',
    render: (_r, index) => h('span', index + 1),
    width: 55,
    align: 'center'
  },
  {
    title: '用户名',
    key: 'username',
    ellipsis: true,
    resizable: true
  },
  {
    title: '创建人',
    key: 'createBy',
    ellipsis: true,
    resizable: true
  },
  {
    title: '创建时间',
    key: 'createTime',
    width: 165,
    ellipsis: true,
    resizable: true
  },
  {
    title: '最后修改人',
    key: 'updateBy',
    ellipsis: true,
    resizable: true
  },
  {
    title: '最后修改时间',
    key: 'updateTime',
    width: 165,
    ellipsis: true,
    resizable: true
  },
  {
    title: '操作',
    key: 'button',
    render: (row) =>
      h('div', [
        h(
          NButton,
          {
            size: 'small',
            quaternary: true,
            type: 'warning',
            focusable: false,
            onClick: () => addForm.value!.show('edit', row)
          },
          { default: () => '修改' }
        ),
        h(
          NButton,
          {
            size: 'small',
            quaternary: true,
            type: 'error',
            focusable: false,
            onClick: () => deleteRow(row)
          },
          { default: () => '删除' }
        )
      ]),
    fixed: 'right',
    align: 'center',
    width: 120
  }
]

const addClick = () => {
  addForm.value!.show('add', {})
}

function deleteRow(row: anyObj) {
  window.$dialog.warning({
    title: '警告',
    content: `确认是否删除用户: ${row.username}`,
    positiveText: '确定',
    negativeText: '取消',
    onPositiveClick: () => {
      console.log('删除成功')
    }
  })
}
</script>
