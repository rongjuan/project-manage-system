import request from '@/utils/request'

export function findByPage(pageNum, pageSize) {
  return request({
    url: '/v1/purchase/orders/v1/order/page',
    method: 'post',
    data: {
      'pageNum': pageNum,
      'pageSize': pageSize
    }
  })
}

export function create(order) {
  return request({
    url: '/v1/purchase/orders/v1/order',
    method: 'post',
    data: order
  })
}

export function update(order) {
  return request({
    url: '/v1/purchase/orders/v1/order',
    method: 'put',
    data: order
  })
}

export function findById(id) {
  return request({
    url: '/v1/purchase/orders/v1/order/' + id,
    method: 'get'
  })
}

export function deleteById(id) {
  return request({
    url: '/v1/purchase/orders/v1/order/' + id,
    method: 'delete'
  })
}
