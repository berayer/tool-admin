<template>
  <div class="flex h-screen items-center justify-center bg-gray-100">
    <n-card class="w-96 rounded-2xl shadow-lg" title="用户登陆" header-style="text-align: center;">
      <n-form
        ref="formRef"
        :show-require-mark="false"
        :model="loginForm"
        :rules="loginRules"
        :on-submit="loginSubmit"
      >
        <n-form-item label="用户名" path="username">
          <n-input v-model:value="loginForm.username" placeholder="请输入用户名"></n-input>
        </n-form-item>

        <n-form-item label="密码" path="password">
          <n-input
            v-model:value="loginForm.password"
            type="password"
            placeholder="请输入密码"
          ></n-input>
        </n-form-item>

        <n-form-item :show-label="false">
          <div class="flex w-full justify-between">
            <n-checkbox v-model:checked="loginForm.rememberMe"> 记住我? </n-checkbox>
            <n-button text :focusable="false">忘记密码?</n-button>
          </div>
        </n-form-item>

        <n-form-item :show-label="false">
          <n-button attr-type="submit" class="w-full" :loading="state.loading"> 登陆 </n-button>
        </n-form-item>
      </n-form>
    </n-card>
  </div>
</template>

<script setup lang="ts">
import { FormRules, FormItemRule, FormInst } from 'naive-ui'
import { v_login } from '@/api'
import { router } from '@/router'

// 状态变量
const state = reactive({
  loading: false
})
// 登陆表单类容
const loginForm = reactive({
  username: '',
  password: '',
  rememberMe: false
})
// 表单对象
const formRef = ref<FormInst | null>(null)
// 表单验证规则
const loginRules: FormRules = {
  username: [
    { required: true, message: '用户名不能为空', trigger: ['blur'] },
    {
      validator(_rule: FormItemRule, value: string) {
        if (value && value.length < 3) {
          return new Error('长度不能小于3')
        }
        return true
      },
      trigger: ['blur']
    }
  ],
  password: [
    { required: true, message: '密码不能为空', trigger: ['blur'] },
    {
      validator(_rule: FormItemRule, value: string) {
        if (value && value.length < 6) {
          return new Error('长度不能小于6')
        }
        return true
      },
      trigger: ['blur']
    }
  ]
}
// 表单提交方法
const loginSubmit = (e: Event) => {
  e.preventDefault()
  console.log(loginForm)
  formRef.value?.validate((errors) => {
    if (!errors) {
      v_login(loginForm).then((res) => {
        if (res.code == 200) {
          console.log(res)
          router.push('/index')
        }
      })
    }
    return false
  })
}
</script>
