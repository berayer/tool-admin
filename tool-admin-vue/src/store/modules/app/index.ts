import { defineStore } from 'pinia'

interface AppState {
  /** 侧边栏折叠状态 */
  siderCollapse: boolean
  siderWidth: number
  siderCollapseWidth: number
}

export const useAppStore = defineStore('app-store', {
  state: (): AppState => ({
    siderCollapse: false,
    siderWidth: 208,
    siderCollapseWidth: 64
  })
})
