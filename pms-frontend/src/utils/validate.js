/**
 * Created by jiachenpan on 16/11/18.
 */

export function isvalidAccount(str) {
  // const valid_map = ['admin', 'editor']
  // return valid_map.indexOf(str.trim()) >= 0
  return str !== null || str !== ''
}

export function isExternal(path) {
  return /^(https?:|mailto:|tel:)/.test(path)
}