import http from '@/utils/request'

/**
 * 新增用户
 * @param data
 */
export function v2_user_add(data: anyObj) {
  return http({
    url: '/user/add',
    method: 'post',
    data: data
  })
}
