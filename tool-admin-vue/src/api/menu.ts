import http from '@/utils/request'

export function v2_menu_search() {
  return http({
    url: '/menu/search'
  })
}
