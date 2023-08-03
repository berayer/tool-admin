import { router } from '@/router'
import type { AxiosRequestConfig } from 'axios'
/* eslint-disable @typescript-eslint/no-explicit-any */
import Axios from 'axios'

const http = Axios.create({
  baseURL: '/v2',
  timeout: 1000 * 5,
  headers: {
    'Content-Type': 'application/json'
  }
})

http.interceptors.request.use(
  (config) => {
    // 检测是否有cookie,如果没有则设置cookie = token
    // console.log(document.cookie)
    return config
  },
  (error) => {
    return Promise.reject(error)
  }
)

http.interceptors.response.use(
  (res) => {
    if (res.data && res.data.code != 200) {
      // 根据错误码统一处理问题
      // 没有认证跳转登陆界面
      window.$notification.error({ title: res.data.msg, content: res.data.data, duration: 1000 })
      return Promise.reject(res.data)
    }
    return res.data
  },
  (error) => {
    httpErrorStatusHandle(error) // 处理错误状态码
    return Promise.reject(error) // 错误继续返回给到具体页面
  }
)

/**
 * 处理异常
 * @param {*} error
 */
function httpErrorStatusHandle(error: any) {
  let message = ''
  if (error && error.response) {
    switch (error.response.status) {
      case 302:
        message = '接口重定向了！'
        break
      case 400:
        message = '参数不正确！'
        break
      case 401:
        message = '您未登录，或者登录已经超时，请先登录！'
        router.push('/login')
        break
      case 403:
        message = '您没有权限操作！'
        router.replace('/403')
        break
      case 404:
        message = '请求地址出错:' + error.response.config.url
        break
      case 408:
        message = '请求超时！'
        break
      case 409:
        message = '系统已存在相同数据！'
        break
      case 500:
        message = '服务器内部错误！'
        router.replace('/500')
        break
      case 501:
        message = '服务未实现！'
        break
      case 502:
        message = '网关错误！'
        break
      case 503:
        message = '服务不可用！'
        break
      case 504:
        message = '服务暂时无法访问，请稍后再试！'
        break
      case 505:
        message = 'HTTP版本不受支持！'
        break
      default:
        message = '异常问题，请联系网站管理员！'
        break
    }
  }
  if (error.message.includes('timeout')) message = '网络请求超时！'
  if (error.message.includes('Network')) {
    message = window.navigator.onLine ? '服务端异常！' : '您断网了！'
  }
  window.$notification.error({ content: message, duration: 2000 })
}

/** 返回数据类型 */
type ApiResult<T> = {
  code: number
  msg: string
  data: T
}

// 请求工具函数
const api = (config: AxiosRequestConfig) => http<any, ApiResult<any>>(config)

export default api
