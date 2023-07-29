<template>
  <m-table></m-table>
</template>

<script setup lang="ts">
import type { DataTableColumns } from 'naive-ui'
import { NSwitch, NButton } from 'naive-ui'
import { ApiRequest, DataTable } from '@/utils/MTable'

const columns: DataTableColumns = [
  {
    type: 'selection',
    width: 40,
    align: 'center'
  },
  {
    title: '序号',
    key: 'no',
    render: (_r, index) => h('span', index),
    width: 55,
    align: 'center'
  },
  {
    title: '用户名',
    key: 'username',
    align: 'center',
    ellipsis: true,
    resizable: true
  },
  {
    title: '昵称',
    key: 'nickName',
    align: 'center',
    ellipsis: true,
    resizable: true
  },
  {
    title: '是否启用',
    key: 'enabled',
    render: (row: anyObj) => h(NSwitch, { defaultValue: row.enabled, disabled: true }),
    width: 80,
    align: 'center'
  },
  {
    title: '创建人',
    key: 'createBy',
    align: 'center',
    ellipsis: true,
    resizable: true
  },
  {
    title: '创建时间',
    key: 'createTime',
    align: 'center',
    width: 165,
    ellipsis: true,
    resizable: true
  },
  {
    title: '最后修改人',
    key: 'updateBy',
    align: 'center',
    ellipsis: true,
    resizable: true
  },
  {
    title: '最后修改时间',
    key: 'updateTime',
    align: 'center',
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
            onClick: () => updateRow(row)
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

function updateRow(row: anyObj) {
  console.log(row)
}

function deleteRow(row: anyObj) {
  window.$dialog.warning({
    title: '警告',
    content: `确认删除用户: ${row.username}?`,
    positiveText: '确定',
    negativeText: '取消',
    onPositiveClick: () => {
      console.log('删除成功')
    }
  })
}

// function loadUsers(page: number) {
//   v_user_list({ page: page, size: 20 }).then((res) => {
//     // console.log(res.data.records)
//     const list = res.data.records as never[]
//     data.userList.push(...list)
//   })
// }

const userTable = new DataTable(columns, new ApiRequest('/user'))
provide('m-table', userTable)
userTable.loadData()
</script>
