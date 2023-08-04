import {defineStore} from 'pinia'

interface AppState {
  /** 侧边栏折叠状态 */
  siderCollapse: boolean
  /** 侧边栏宽度 */
  siderWidth: number
  /** 侧边栏折叠之后的宽度 */
  siderCollapseWidth: number
}

export const useAppStore = defineStore('app-store', {
  state: (): AppState => ({
    siderCollapse: false,
    siderWidth: 224,
    siderCollapseWidth: 64
  })
})
