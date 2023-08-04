<template>
  <n-layout has-sider class="h-screen">
    <global-sider />
    <n-layout>
      <global-header />
      <global-content />
    </n-layout>
  </n-layout>
</template>

<script setup lang="ts">
import GlobalContent from './components/global-content.vue'
import GlobalHeader from './components/global-header.vue'
import GlobalSider from './components/global-sider.vue'
</script>
