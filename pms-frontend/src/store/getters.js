// 导出模块
const getters = {
  sidebar: state => state.app.sidebar,
  device: state => state.app.device,
  token: state => state.user.token,
  id: state => state.user.id,
  name: state => state.user.name,
  avatar: state => state.user.avatar,
  menus: state => state.user.menus
}
export default getters
