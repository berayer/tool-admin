<template>
  <n-modal
    style="width: 400px"
    :show="state.show"
    preset="dialog"
    :title="state.type == 'add' ? '新增' : '修改'"
    :type="state.type == 'add' ? 'info' : 'warning'"
    :mask-closable="false"
    negative-text="取消"
    positive-text="保存"
  >
    <n-form class="my-6" label-width="80px">
      <n-form-item label="角色名称">
        <n-input v-model:value="data.name"></n-input>
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

const state = reactive({
  show: false,
  type: ''
})
const data = ref<anyObj>({})

/**
 * 打开弹窗
 * @param type 类型 add:新增 edit:编辑
 * @param obj 对象数据
 */
function show(type: 'add' | 'edit', obj: anyObj) {
  data.value = obj
  state.show = true
  state.type = type
}

/**
 * 暴露方法
 */
defineExpose({
  show
})
</script>
