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
  setupStore(app)
  await setupRouter(app)
  app.mount('#app')
}

// 异步挂载vue实例
await setupApp()
