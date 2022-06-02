import { createRouter, createWebHashHistory } from 'vue-router'

const routes = [
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/login.vue')
  },
  {
    path: '/home',
    name: 'Home',
    component: () => import('@/views/home.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(), //hash模式
  routes: routes
})

export default router