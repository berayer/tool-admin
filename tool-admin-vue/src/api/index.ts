import http from '@/utils/request'

/**
 * 用户后台登陆接口
 * @param data 登陆表单数据
 */
export function v2_login(data: Record<string, unknown>) {
  return http({
    url: '/login',
    method: 'post',
    data
  })
}

export function v_user_list(params: { page: number; size: number }) {
  return http({
    url: '/user/search',
    method: 'get',
    params
  })
}

export function v_index_info() {
  return http({
    url: '/index',
    method: 'get'
  })
}

export function v_menu_list() {
  return http({
    url: '/menu/search',
    method: 'get'
  })
}

export function v2_userMenu() {
  return http({
    url: '/menu/userMenu',
    method: 'get'
  })
}

export function v2_logout() {
  return http({
    url: '/logout',
    method: 'post'
  })
}

export * from './user'
export * from './menu'
