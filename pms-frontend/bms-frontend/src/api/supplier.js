import request from '@/utils/request'

export function findByPage(pageNum, pageSize) {
  return request({
    url: '/v1/suppliers/v1/supplier/page',
    method: 'post',
    data: {
      'pageNum': pageNum,
      'pageSize': pageSize
    }
  })
}

export function create(supplier) {
  return request({
    url: '/v1/suppliers/v1/supplier',
    method: 'post',
    data: supplier
  })
}

export function update(supplier) {
  return request({
    url: '/v1/suppliers/v1/supplier',
    method: 'put',
    data: supplier
  })
}

export function findById(id) {
  return request({
    url: '/v1/suppliers/v1/supplier/' + id,
    method: 'get'
  })
}

export function deleteById(id) {
  return request({
    url: '/v1/suppliers/v1/supplier/' + id,
    method: 'delete'
  })
}

export function findAllSuppliers() {
  return request({
    url: '/v1/suppliers/v1/supplier',
    method: 'get'
  })
}
