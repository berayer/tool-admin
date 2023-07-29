export const mock_users = (num: number) => genData(num)

function genData(t: number) {
  const item = {
    id: 1,
    username: 'admin',
    nickName: '超级管理员',
    enabled: true,
    createBy: 'system',
    createTime: '2023-06-20 21:12:36'
  }

  const s: any = new Array(t)
  s.fill(item, 0, t)
  return s
}
