<template>
  <n-modal :v-model:show="show">
    <n-form>
      <n-form-item label="菜单名称">
        <n-input></n-input>
      </n-form-item>

      <n-form-item label="菜单图标">
        <n-input></n-input>
      </n-form-item>

      <n-form-item label="类型">
        <n-input></n-input>
      </n-form-item>

      <n-form-item label="菜单路径">
        <n-input></n-input>
      </n-form-item>

      <n-form-item label="菜单名称">
        <n-input></n-input>
      </n-form-item>
    </n-form>
  </n-modal>
</template>

<script setup lang="ts">
defineProps(['show'])
defineEmits(['update:show'])
</script>
