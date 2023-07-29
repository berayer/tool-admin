import { createApp } from 'vue'
import App from './App.vue'
import { setupRouter } from '@/router'
import { setupStore } from '@/store'
// 静态资源导入
import './styles/index.css'
//引入echarts
import 'echarts'

async function setupApp() {
  const app = createApp(App)
  await setupRouter(app)
  setupStore(app)
  // addNaiveMetaStyle()
  app.mount('#app')
}

// 异步挂载vue实例
setupApp()

/**
 * 解决Native-ui 和 tailwind css 样式冲突问题
 * 加载此项后, 无法在UI组件上使用 tailwind css
 */
function addNaiveMetaStyle() {
  const meta = document.createElement('meta')
  meta.name = 'naive-ui-style'
  document.head.appendChild(meta)
}
