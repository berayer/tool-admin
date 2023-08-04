<template>
  <n-config-provider :locale="zhCN" :theme-overrides="DefaultTheme">
    <naive-provider>
      <RouterView />
    </naive-provider>
  </n-config-provider>
</template>

<script setup lang="ts">
import { zhCN } from 'naive-ui'
import { DefaultTheme } from '@/themes'
</script>
