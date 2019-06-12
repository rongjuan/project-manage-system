import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/pms/v1/users/v1/user/login',
    method: 'post',
    data
  })
}

export function getUser(token) {
  return request({
    url: '/pms/v1/users/v1/user/info',
    method: 'get'
  })
}

export function getUserList(data) {
  return request({
    url: '/pms/v1/users/v1/user/list',
    method: 'post',
    data
  })
}

export function getAllUser(data) {
  return request({
    url: '/pms/v1/users/v1/user',
    method: 'get'
  })
}

export function createUser(data) {
  return request({
    url: '/pms/v1/users/v1/user',
    method: 'post',
    data
  })
}

export function updateUser(data) {
  return request({
    url: '/pms/v1/users/v1/user',
    method: 'put',
    data
  })
}

export function deleteUser(id) {
  return request({
    url: '/pms/v1/users/v1/user/' + id,
    method: 'delete'
  })
}

export function deleteBatchUser(data) {
  return request({
    url: '/pms/v1/users/v1/user/batch',
    method: 'delete',
    data
  })
}

export function existUser(account) {
  return request({
    url: '/pms/v1/users/v1/user/' + account + '/existed',
    method: 'get'
  })
}

export function updateUserSecret(data) {
  return request({
    url: '/pms/v1/users/v1/user/secret',
    method: 'put',
    data
  })
}
