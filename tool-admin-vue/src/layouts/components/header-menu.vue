<template>
  <div class="flex h-full items-center">
    <div class="flex h-full items-center px-2 hover:cursor-pointer hover:bg-gray-100">
      <m-icon name="carbon:search" :size="20"></m-icon>
    </div>

    <div class="flex h-full items-center px-2 hover:cursor-pointer hover:bg-gray-100">
      <m-icon name="carbon:logo-github" :size="20"></m-icon>
    </div>

    <div class="flex h-full items-center px-2 hover:cursor-pointer hover:bg-gray-100">
      <m-icon name="carbon:notification" :size="20"></m-icon>
    </div>

    <div class="flex h-full select-none items-center px-2 hover:cursor-pointer hover:bg-gray-100">
      <n-dropdown :options="userOption" size="large" :on-select="userInfoSelect">
        <div class="flex items-center space-x-2">
          <n-avatar
            round
            size="small"
            src="https://07akioni.oss-cn-beijing.aliyuncs.com/07akioni.jpeg"
          />
          <span class="text-md"> 超级管理员 </span>
        </div>
      </n-dropdown>
    </div>
  </div>
</template>

<script setup lang="ts">
import type { DropdownOption } from 'naive-ui'
import MIcon from '@/components/m-icon/index.vue'
import { router } from '@/router'
import { useUserStore } from '@/store'

const userOption: DropdownOption[] = [
  {
    label: '个人中心',
    key: 'userInfo',
    icon: () => h(MIcon, { name: 'carbon:user-identification' }, { default: () => '' })
  },
  {
    label: '退出登陆',
    key: 'logout',
    icon: () => h(MIcon, { name: 'carbon:logout' }, { default: () => '' })
  }
]

/**
 * 用户信息下拉菜单选择回调
 * @param key
 */
const userInfoSelect = async (key: string) => {
  if (key === 'logout') {
    await useUserStore().logout()
    window.$message.success('登出成功')
    router.push('/login')
  } else {
    window.$message.info(key)
  }
}
</script>
