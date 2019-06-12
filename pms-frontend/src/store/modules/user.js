import { login, getUser } from '@/api/user'
import { getToken, setToken, removeToken } from '@/utils/auth'
import { resetRouter } from '@/router'

// 初始化
const state = {
  token: getToken(),
  id: '',
  name: '',
  avatar: '',
  menus: []
}

// 同步（修改）
const mutations = {
  SET_TOKEN: (state, token) => {
    state.token = token
  },
  SET_ID: (state, id) => {
    state.id = id
  },
  SET_NAME: (state, name) => {
    state.name = name
  },
  SET_AVATAR: (state, avatar) => {
    state.avatar = avatar
  },
  SET_MENUS: (state, menus) => {
    state.menus = menus
  }
}

// 异步（修改）
const actions = {
  login({ commit }, userInfo) {
    const { account, secret } = userInfo
    return new Promise((resolve, reject) => {
      login({ account: account.trim(), secret: secret }).then(response => {
        const { data } = response
        commit('SET_TOKEN', data)
        setToken(data)
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },
  getInfo({ commit, state }) {
    return new Promise((resolve, reject) => {
      getUser(state.token).then(response => {
        const { data } = response
        if (!data) {
          reject('Verification failed, please Login again.')
        }
        const { id, name, photo, menus } = data
        commit('SET_ID', id)
        commit('SET_NAME', name)
        commit('SET_AVATAR', photo)
        commit('SET_MENUS', menus)
        resolve(data)
      }).catch(error => {
        reject(error)
      })
    })
  },
  logout({ commit }) {
    commit('SET_TOKEN', '')
    commit('SET_ID', '')
    removeToken()
    resetRouter()
  },
  resetToken({ commit }) {
    return new Promise(resolve => {
      commit('SET_TOKEN', '')
      commit('SET_ID', '')
      removeToken()
      resolve()
    })
  }
}

// 导出
export default {
  namespaced: true,
  state,
  mutations,
  actions
}

