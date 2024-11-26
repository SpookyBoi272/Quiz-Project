import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import QuizesView from '@/views/MyQuizesView.vue'
import ExploreView from '../views/ExploreView.vue'
import MyStatsView from '@/views/MyStatsView.vue'
import LoginView from '@/views/LoginView.vue'
import SignUpView from '@/views/SignUpView.vue'
import FallbackView from '@/views/FallbackView.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login',
      name: 'login',
      component: LoginView,
      meta: { hideHeader: true },
    },
    {
      path: '/signup',
      name: 'signup',
      component: SignUpView,
      meta: { hideHeader: true },
    },
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/quizes',
      name: 'quizes',
      component: QuizesView,
    },
    {
      path: '/explore',
      name: 'expolre',
      component: ExploreView,
    },
    {
      path: '/mystats',
      name: 'mystats',
      component: MyStatsView,
    },
    {
      path: '/fallback',
      name: 'fall-back',
      component: FallbackView,
    },
    {
      path: '/:pathMatch(.*)*',
      redirect: '/fallback',
    },    
  ],
})

export default router
