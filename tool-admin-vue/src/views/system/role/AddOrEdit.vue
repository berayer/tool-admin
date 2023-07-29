<template>
  <n-modal
    style="width: 400px"
    :show="show"
    preset="dialog"
    :title="type == 'add' ? '新增' : '修改'"
    :type="type == 'add' ? 'info' : 'warning'"
    :mask-closable="false"
    negative-text="取消"
    positive-text="保存"
    :on-update-show="(v) => $emit('update:show', v)"
  >
    <n-form class="my-6" label-width="80px">
      <n-form-item label="角色名称">
        <n-input></n-input>
      </n-form-item>

      <n-form-item label="权限">
        <div class="flex w-full justify-center border border-solid border-gray-100">
          <n-scrollbar style="height: 220px">
            <n-tree key-field="id" checkable :data="appMenu"> </n-tree>
          </n-scrollbar>
        </div>
      </n-form-item>
    </n-form>
  </n-modal>
</template>

<script setup lang="ts">
import { appMenu } from '@/mock'

defineProps<{ show: boolean; type: 'add' | 'edit' }>()
defineEmits<{
  'update:show': [show: boolean]
}>()
</script>
