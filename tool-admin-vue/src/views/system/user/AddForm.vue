<template>
  <n-modal
    v-model:show="state.show"
    style="width: 400px"
    preset="dialog"
    :title="state.type == 'add' ? '新增' : '修改'"
    :type="state.type == 'add' ? 'info' : 'warning'"
    :mask-closable="false"
    negative-text="取消"
    positive-text="保存"
    :on-positive-click="okButtonClick"
  >
    <n-form class="my-6" label-width="80px">
      <n-form-item label="用户名">
        <n-input v-model:value="data.username"></n-input>
      </n-form-item>

      <n-form-item label="密码">
        <n-input v-model:value="data.password" type="password"></n-input>
      </n-form-item>

      <n-form-item label="确认密码">
        <n-input v-model:value="data.rePassowrd" type="password"></n-input>
      </n-form-item>
    </n-form>
  </n-modal>
</template>

<script setup lang="ts">
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
  state.type = type
  state.show = true
  console.log(data.value)
}

const okButtonClick = () => {
  const a = data.value.password as string
  const b = data.value.rePassowrd as string
  if (a === b) {
    alert('ok')
  } else {
    alert('两次密码不一致')
    return false
  }
  return true
}
/**
 * 暴露方法
 */
defineExpose({
  show
})
</script>
