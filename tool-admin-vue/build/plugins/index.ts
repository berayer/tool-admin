import type {PluginOption} from 'vite'
import vue from '@vitejs/plugin-vue'
import unplugin from './unplugin'

/**
 * vite插件
 * @param viteEnv - 环境变量配置
 */
export function setupVitePlugins(viteEnv: ImportMetaEnv): (PluginOption | PluginOption[])[] {
  const plugins = [vue(), ...unplugin()]

  // 此处可以根据条件添加插件

  return plugins
}
