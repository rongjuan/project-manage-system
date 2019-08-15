import request from '@/utils/request'

export function getAllMenu (data) {
  return request({
    url: '/pms/v1/menus/v1/menu',
    method: 'get'
  })
}

export function getMenuById (id) {
  return request({
    url: '/pms/v1/menus/v1/menu/' + id,
    method: 'get'
  })
}

export function createMenu (data) {
  return request({
    url: '/pms/v1/menus/v1/menu',
    method: 'post',
    data
  })
}

export function updateMenu (data) {
  return request({
    url: '/pms/v1/menus/v1/menu',
    method: 'put',
    data
  })
}

export function removeMenu (id) {
  return request({
    url: '/pms/v1/menus/v1/menu/' + id,
    method: 'delete'
  })
}
