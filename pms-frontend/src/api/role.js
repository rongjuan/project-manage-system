import request from '@/utils/request'

export function getRoleList(data) {
  return request({
    url: '/pms/v1/roles/v1/role/list',
    method: 'post',
    data
  })
}

export function createRole(data) {
  return request({
    url: '/pms/v1/roles/v1/role',
    method: 'post',
    data
  })
}

export function updateRole(data) {
  return request({
    url: '/pms/v1/roles/v1/role',
    method: 'put',
    data
  })
}

export function deleteRole(id) {
  return request({
    url: '/pms/v1/roles/v1/role/' + id,
    method: 'delete'
  })
}

export function deleteBatchRole(data) {
  return request({
    url: '/pms/v1/roles/v1/role/batch',
    method: 'delete',
    data
  })
}

export function getRoleUser(id) {
  return request({
    url: '/pms/v1/roles/v1/role/' + id + '/user',
    method: 'get'
  })
}

export function saveRoleUser(data) {
  return request({
    url: '/pms/v1/roles/v1/role/user',
    method: 'put',
    data
  })
}

export function getRoleMenu(id) {
  return request({
    url: '/pms/v1/roles/v1/role/' + id + '/menu',
    method: 'get'
  })
}

export function saveRoleMenu(data) {
  return request({
    url: '/pms/v1/roles/v1/role/menu',
    method: 'put',
    data
  })
}
