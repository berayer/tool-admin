/**
 * vite 环境变量类型提醒
 */
interface ImportMetaEnv {
  /** 程序端口 */
  readonly VITE_PORT: number
  /** APP根路径 */
  readonly VITE_APP_BASE_URL: string
  /** 后台代理地址 */
  readonly VITE_PROXY_URL: string
  /** APP名称 */
  readonly VITE_APP_NAME: string
}

interface ImportMeta {
  readonly env: ImportMetaEnv
}
