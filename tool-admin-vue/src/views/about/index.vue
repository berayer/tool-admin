<template>
  <n-card>
    <n-form ref="formRef" :model="da" :rules="rules" :show-require-mark="true">
      <n-form-item label="name" path="name">
        <n-input v-model:value="da.name"></n-input>
      </n-form-item>

      <n-form-item>
        <n-button @click="handleValidateClick">验证</n-button>
      </n-form-item>
    </n-form>
  </n-card>
</template>

<script setup lang="ts">
import { FormRules, FormInst } from 'naive-ui'

const formRef = ref<FormInst | null>(null)
const da = reactive({
  name: ''
})

const rules: FormRules = {
  name: [{ required: true, message: 'name can not be null', trigger: ['blur', 'input', 'change'] }]
}

function handleValidateClick(e: MouseEvent) {
  e.preventDefault()
  formRef.value?.validate((errors) => {
    if (!errors) {
      window.$message.success('Valid')
    } else {
      console.log(errors)
      window.$message.error('Invalid')
    }
  })
}
</script>
