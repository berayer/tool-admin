<template>
  <div class="flex h-screen items-center justify-center bg-gray-100">
    <n-result status="500" title="500 服务器错误" description="请联系管理员 || 稍后再试">
      <template #footer>
        <n-button :focusable="false" @click="router.replace('/index')">返回</n-button>
        <n-button :focusable="false" @click="router.replace('/index')">回到首页</n-button>
      </template>
    </n-result>
  </div>
</template>

<script setup lang="ts">
import { router } from '@/router'
</script>
