import request from '@/utils/request'

export function findByPage(pageNum, pageSize) {
  return request({
    url: '/v1/projects/v1/project/page',
    method: 'post',
    data: {
      'pageNum': pageNum,
      'pageSize': pageSize
    }
  })
}

export function create(project) {
  return request({
    url: '/v1/projects/v1/project',
    method: 'post',
    data: project
  })
}

export function update(project) {
  return request({
    url: '/v1/projects/v1/project',
    method: 'put',
    data: project
  })
}

export function findAllProjects() {
  return request({
    url: '/v1/projects/v1/project',
    method: 'get'
  })
}

export function findById(id) {
  return request({
    url: '/v1/projects/v1/project/' + id,
    method: 'get'
  })
}

export function deleteById(id) {
  return request({
    url: '/v1/projects/v1/project/' + id,
    method: 'delete'
  })
}
