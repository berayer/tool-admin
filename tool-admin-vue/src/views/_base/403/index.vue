<template>
  <div class="flex h-screen items-center justify-center bg-gray-100">
    <n-result status="403" title="403 禁止访问" description="总有些门是对你关闭的">
      <template #footer>
        <n-button :focusable="false">放轻松</n-button>
        <IconSlect />
      </template>
    </n-result>
  </div>
</template>
