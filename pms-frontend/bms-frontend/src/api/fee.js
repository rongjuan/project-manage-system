import request from '@/utils/request'

export function findByPage(pageNum, pageSize) {
  return request({
    url: '/v1/fees/v1/fee/page',
    method: 'post',
    data: {
      'pageNum': pageNum,
      'pageSize': pageSize
    }
  })
}

export function create(fee) {
  return request({
    url: '/v1/fees/v1/fee',
    method: 'post',
    data: fee
  })
}

export function update(fee) {
  return request({
    url: '/v1/fees/v1/fee',
    method: 'put',
    data: fee
  })
}

export function findAll() {
  return request({
    url: '/v1/fees/v1/fee',
    method: 'get'
  })
}

export function findById(id) {
  return request({
    url: '/v1/fees/v1/fee/' + id,
    method: 'get'
  })
}

export function deleteById(id) {
  return request({
    url: '/v1/fees/v1/fee/' + id,
    method: 'delete'
  })
}
