<template>
  <div @click="loadForm">menu</div>
  <MTable />
  <!-- <n-data-table :columns="columns" :data="data"> </n-data-table> -->
  <MenuForm v-model:show="showForm" />
</template>

<script setup lang="ts">
// import { v_menu_list } from '@/api'
import type { DataTableColumns } from 'naive-ui'
import Icon from '@/components/Icon.vue'
import { DataTable, ApiRequest } from '@/utils/MTable'
import MenuForm from './MenuForm.vue'

const showForm = ref(false)
function loadForm() {
  console.log('show')
  showForm.value = true
}

// const data = ref([])
const columns: DataTableColumns = [
  {
    title: '名称',
    key: 'name'
  },
  {
    title: '图标',
    key: 'icon',
    render: (row) => h(Icon, { name: row.icon as string, size: 18 })
  },
  {
    title: '路径',
    key: 'path'
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
  }
]

// onMounted(() => {
//   v_menu_list().then((res) => {
//     console.log(res)
//     data.value = res.data
//   })
// })

const mtable = new DataTable(columns, new ApiRequest('/menu'), false)
provide('m-table', mtable)
mtable.loadData()
</script>
