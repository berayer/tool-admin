<template>
  <div class="bg-green-200">header</div>
  <div class="flex flex-1 items-center justify-end bg-red-100">
    <div style="padding-right: 20%">
      <default-login />
    </div>
  </div>
  <div class="bg-purple-200">footer</div>
</template>

<script setup lang="ts">
import defaultLogin from './components/defaultLogin.vue'
</script>
