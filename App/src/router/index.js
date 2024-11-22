import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import QuizesView from '@/views/QuizesView.vue'
import ExploreView from '../views/ExploreView.vue'
import MyStatsView from '@/views/MyStatsView.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/home',
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
  ],
})

export default router
