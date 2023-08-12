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

enum MenuType {
  /** 菜单路由 */
  ROUTE = 1,
  /** 外链接 */
  BLANK,
  /** 内嵌页面 */
  IFARME
}

type AppMenu = {
  id: number
  title: string
  name: string
  path: string
  type: MenuType
  icon: string
  children?: AppMenu[]
}

type anyObj = {
  [key: string | number | symbol]: any
}
