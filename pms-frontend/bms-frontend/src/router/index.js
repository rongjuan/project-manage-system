import Vue from 'vue'
import Router from 'vue-router'

// in development-env not use lazy-loading, because lazy-loading too many pages will cause webpack hot update too slow. so only in production use lazy-loading;
// detail: https://panjiachen.github.io/vue-element-admin-site/#/lazy-loading

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'

/**
* hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
* alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
*                                if not set alwaysShow, only more than one route under the children
*                                it will becomes nested mode, otherwise not show the root menu
* redirect: noredirect           if `redirect:noredirect` will no redirect in the breadcrumb
* name:'router-name'             the name is used by <keep-alive> (must set!!!)
* meta : {
    title: 'title'               the name show in subMenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    breadcrumb: false            if false, the item will hidden in breadcrumb(default is true)
  }
**/
export const constantRouterMap = [
  { path: '/login', component: () => import('@/views/login/index'), hidden: true },
  { path: '/404', component: () => import('@/views/404'), hidden: true },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    name: 'Dashboard',
    hidden: true,
    children: [{
      path: 'dashboard',
      component: () => import('@/views/dashboard/index')
    }]
  },

  {
    path: '/fee',
    component: Layout,
    redirect: '/fee',
    name: 'Fee',
    hidden: false,
    meta: { title: '费用类型', icon: 'example' },
    children: [{
      path: 'fee',
      component: () => import('@/views/fee/index')
    }]
  },

  {
    path: '/supplier',
    component: Layout,
    redirect: '/supplier',
    name: 'Supplier',
    hidden: false,
    meta: { title: '供应商', icon: 'table' },
    children: [{
      path: 'supplier',
      component: () => import('@/views/supplier/index')
    }]
  },

  {
    path: '/commodity',
    component: Layout,
    redirect: '/commodity',
    name: 'Commodity',
    hidden: false,
    meta: { title: '商品', icon: 'tree' },
    children: [{
      path: 'commodity',
      component: () => import('@/views/commodity/index')
    }]
  },

  {
    path: '/project',
    component: Layout,
    redirect: '/project',
    name: 'Project',
    hidden: false,
    meta: { title: '项目', icon: 'link' },
    children: [{
      path: 'project',
      component: () => import('@/views/project/index')
    }]
  },

  {
    path: '/purchase-order',
    component: Layout,
    redirect: '/purchase-order',
    name: 'PurchaseOrder',
    hidden: false,
    meta: { title: '采购订单', icon: 'form' },
    children: [{
      path: 'project',
      component: () => import('@/views/purchaseOrder/index')
    }]
  },

  { path: '*', redirect: '/404', hidden: true }
]

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})
