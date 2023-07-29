<template>
  <div class="flex h-screen items-center justify-center bg-gray-100">
    <n-result status="404" title="404 资源不存在" description="生活总归带点荒谬">
      <template #footer>
        <n-button :focusable="false">找点乐子吧</n-button>
      </template>
    </n-result>
  </div>
</template>
