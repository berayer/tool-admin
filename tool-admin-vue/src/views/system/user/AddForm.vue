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
    :loading="state.loading"
  >
    <n-form ref="formRef" :rules="rules" :model="data" show-require-mark class="my-6" label-width="80px">
      <n-form-item label="用户名" path="username">
        <n-input v-model:value="data.username"></n-input>
      </n-form-item>

      <n-form-item label="密码" path="password">
        <n-input v-model:value="data.password" type="password"></n-input>
      </n-form-item>

      <n-form-item label="确认密码" path="rePassword">
        <n-input v-model:value="data.rePassword" type="password" :disabled="!data.password"></n-input>
      </n-form-item>
    </n-form>
  </n-modal>
</template>

<script setup lang="ts">
import { FormRules, FormInst } from 'naive-ui'
import { v2_user_add } from '@/api'

const formRef = ref<FormInst | null>(null)
const state = reactive({
  show: false,
  type: '',
  loading: false
})
const data = ref<anyObj>({})
const rules: FormRules = {
  username: [{ required: true, message: '用户名称不能为空', trigger: ['blur', 'input'] }],
  password: [
    { required: true, message: '密码不能为空', trigger: ['blur', 'input'] },
    {
      validator: (_rule, value) => {
        if (value && value.length < 6) {
          return new Error('密码不能小于6位')
        }
        return true
      },
      trigger: 'input'
    }
  ],
  rePassword: [
    { required: true, message: '请再次输入密码' },
    {
      validator: (_rule, value) => {
        return value === data.value.password
      },
      message: '两次密码输入不一致',
      trigger: ['blur']
    }
  ]
}

/**
 * 打开弹窗
 * @param type 类型 add:新增 edit:编辑
 * @param obj 对象数据
 */
function show(type: 'add' | 'edit', obj?: anyObj) {
  if (type === 'add') obj = {}
  data.value = obj!
  state.type = type
  state.show = true
  console.log(data.value)
}

const okButtonClick = () => {
  formRef.value?.validate((errors) => {
    if (!errors) {
      state.loading = true
      v2_user_add(data.value)
        .then(() => {
          window.$message.success('添加成功')
          state.show = false
        })
        .finally(() => {
          state.loading = false
        })
    }
  })
  return false
}

/**
 * 暴露方法
 */
defineExpose({
  show
})
</script>
