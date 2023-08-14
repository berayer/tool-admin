<template>
  <n-layout has-sider class="h-screen">
    <global-sider />
    <n-layout ref="appContent" class="h-screen">
      <global-header style="height: 56px" />
      <global-content style="height: calc(100% - 56px)" />
    </n-layout>
  </n-layout>
</template>

<script setup lang="ts">
import GlobalContent from './components/global-content.vue'
import GlobalHeader from './components/global-header.vue'
import GlobalSider from './components/global-sider.vue'
</script>
