import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: require('@/components/HelloWorld').default
    }, {
      path: '/login',
      name: 'Login',
      component: require('@/components/Login').default
    }, {
      path: '/alert',
      name: 'Alert',
      component: require('@/components/Alert').default
    }, {
      path: '*',
      redirect: '/'
    }
  ]
})
