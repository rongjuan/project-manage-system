import request from '@/utils/request'

export function findByPage(pageNum, pageSize) {
  return request({
    url: '/v1/commodities/v1/commodity/page',
    method: 'post',
    data: {
      'pageNum': pageNum,
      'pageSize': pageSize
    }
  })
}

export function create(commodity) {
  return request({
    url: '/v1/commodities/v1/commodity',
    method: 'post',
    data: commodity
  })
}

export function update(commodity) {
  return request({
    url: '/v1/commodities/v1/commodity',
    method: 'put',
    data: commodity
  })
}

export function findById(id) {
  return request({
    url: '/v1/commodities/v1/commodity/' + id,
    method: 'get'
  })
}

export function deleteById(id) {
  return request({
    url: '/v1/commodities/v1/commodity/' + id,
    method: 'delete'
  })
}

export function findAllCommodities() {
  return request({
    url: '/v1/commodities/v1/commodity',
    method: 'get'
  })
}
