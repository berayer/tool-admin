/* eslint-disable @typescript-eslint/no-explicit-any */
/**
 * 全局变量配置
 */

interface Window {
  $loadingBar: import('naive-ui').LoadingBarProviderInst
  $dialog: import('naive-ui').DialogProviderInst
  $message: import('naive-ui').MessageProviderInst
  $notification: import('naive-ui').NotificationProviderInst
  isLoading: boolean
}

type AppMenu = {
  id: number
  name: string
  path: string
  icon?: string
  children?: AppMenu[]
}

type anyObj = {
  [key: string]: any
}
