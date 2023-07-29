export const appMenu: AppMenu[] = [
  {
    id: 1,
    label: '首页',
    icon: 'mdi:home-outline',
    path: '/home'
  },
  {
    id: 9,
    label: '联思工具',
    icon: 'mdi:wrench-outline',
    path: '/imes'
  },
  {
    id: 2,
    label: '系统设置',
    icon: 'mdi:cog-outline',
    path: '/system',
    children: [
      {
        id: 3,
        label: '用户管理',
        icon: 'mdi:account-outline',
        path: '/system/user'
      },
      {
        id: 4,
        label: '角色管理',
        icon: 'mdi:account-group-outline',
        path: '/system/role'
      },
      {
        id: 5,
        label: '菜单管理',
        icon: 'mdi:view-grid-outline',
        path: '/system/menu'
      }
    ]
  },
  {
    id: 13,
    label: 'Threejs',
    icon: 'mdi:star-three-points-outline',
    path: '/test'
  },
  {
    id: 6,
    label: '关于',
    icon: 'mdi:information-outline',
    path: '/about'
  }
]
