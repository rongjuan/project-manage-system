import request from '@/utils/request'

export function login(account, password) {
  return request({
    url: '/v1/users/v1/user/login',
    method: 'post',
    data: {
      'account': account,
      'password': password
    }
  })
}

export function find(token) {
  return request({
    url: '/v1/users/v1/user/' + token,
    method: 'get'
  })
}

export function findAll() {
  return request({
    url: '/v1/users/v1/user',
    method: 'get'
  })
}

export function logout() {
  return request({
    url: '/user/logout',
    method: 'post'
  })
}
