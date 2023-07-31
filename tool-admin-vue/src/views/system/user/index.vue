<template>
  <m-table :columns="columns" :row-key="(i) => i.id" />
</template>

<script setup lang="ts">
import type { DataTableColumns } from 'naive-ui'
import { NButton, NSwitch } from 'naive-ui'
// import {ApiRequest, DataTable} from '@/utils/MTable'

// import {useStore} from 'vuex'
// import {useRouter} from 'vue-router''

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
    render: () =>
      h('div', [
        h(
          NButton,
          {
            size: 'small',
            quaternary: true,
            type: 'warning',
            focusable: false
            // onClick: () => updateRow(row)
          },
          { default: () => '修改' }
        ),
        h(
          NButton,
          {
            size: 'small',
            quaternary: true,
            type: 'error',
            focusable: false
            // onClick: () => deleteRow(row)
          },
          { default: () => '删除' }
        )
      ]),
    fixed: 'right',
    align: 'center',
    width: 120
  }
]

// function updateRow(row: anyObj) {
//   console.log(row)
// }

// function deleteRow(row: anyObj) {
//   window.$dialog.warning({
//     title: '警告',
//     content: `确认删除用户: ${row.username}?`,
//     positiveText: '确定',
//     negativeText: '取消',
//     onPositiveClick: () => {
//       console.log('删除成功')
//     }
//   })
// }

// const userTable = new DataTable(columns, new ApiRequest('/user'))
// provide('m-table', userTable)
// userTable.loadData()
</script>
