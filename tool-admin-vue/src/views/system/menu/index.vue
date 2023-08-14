<template>
  <m-table :columns="menuColumns" base-url="/menu" size="small" @add-click="state.addFormModal = true"></m-table>
  <add-form v-model:show="state.addFormModal" />
</template>

<script setup lang="ts">
import MIcon from '@/components/m-icon/index.vue'
import type { DataTableColumns } from 'naive-ui'
import { NTag } from 'naive-ui'
import AddForm from './add-form.vue'

const state = reactive({
  addFormModal: false
})

const menuColumns: DataTableColumns = [
  {
    key: 'title',
    title: '标题',
    titleAlign: 'center'
  },
  {
    key: 'path',
    title: '路径',
    align: 'center'
  },
  {
    key: 'name',
    title: '名称',
    align: 'center'
  },
  {
    key: 'type',
    title: '菜单类型',
    render: (row) => menuTypeRender(row.type as number),
    align: 'center'
  },
  {
    key: 'icon',
    title: '图标',
    render: (row) => h(MIcon, { name: row.icon as string, size: 20 }, { default: () => '' }),
    align: 'center'
  },
  {
    key: 'createBy',
    title: '创建人',
    align: 'center'
  },
  {
    key: 'createTime',
    title: '创建时间',
    width: 150,
    align: 'center'
  },
  {
    key: 'updateBy',
    title: '最后修改人',
    align: 'center'
  },
  {
    key: 'updateTime',
    title: '最后修改时间',
    width: 150,
    align: 'center'
  }
]

type LabelType = 'default' | 'success' | 'error' | 'warning' | 'primary' | 'info' | undefined
/**
 * 返回菜单类型渲染函数
 * @param type 菜单类型
 */
function menuTypeRender(type: number) {
  const opt = {
    type: undefined as LabelType,
    label: 'unknow'
  }

  switch (type) {
    case 1:
      opt.type = 'success'
      opt.label = '路由'
      break
    case 2:
      opt.type = 'info'
      opt.label = '外链接'
      break
    case 3:
      opt.type = 'success'
      opt.label = 'ifarme'
      break
    default:
      opt.type = 'warning'
      opt.label = '未识别'
  }

  return h(NTag, { type: opt.type }, { default: () => opt.label })
}
</script>
