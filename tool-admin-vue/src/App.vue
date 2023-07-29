<template>
  <n-config-provider :locale="zhCN" :theme-overrides="themeOverrides">
    <NaiveProvider>
      <RouterView />
    </NaiveProvider>
  </n-config-provider>
</template>

<script setup lang="ts">
import { zhCN } from 'naive-ui'
import type { GlobalThemeOverrides } from 'naive-ui'

const themeOverrides: GlobalThemeOverrides = {
  common: {
    primaryColor: '#0084ff'
  },
  Layout: {
    color: '#f3f3f3'
  },
  Card: {
    borderRadius: '16px'
  },
  Divider: {
    color: 'rgb(160 160 160)'
  }
}
</script>
