<template>
  <n-config-provider :locale="zhCN" :theme-overrides="DefaultTheme">
    <n-theme-editor>
      <naive-provider>
        <RouterView />
      </naive-provider>
    </n-theme-editor>
  </n-config-provider>
</template>

<script setup lang="ts">
import { zhCN } from 'naive-ui'
import { DefaultTheme } from '@/themes'
import { NThemeEditor } from 'naive-ui'
</script>
