<script>
import { RouterLink, RouterView } from 'vue-router'
import {MagnifyingGlassIcon} from '@heroicons/vue/16/solid'

export default {
  components: { MagnifyingGlassIcon }
};
</script>

<template>
  <header v-if="!$route.meta.hideHeader">
    <div class="logo">
       <img src="./assets/favicon.ico" alt="logo">
    </div>
    <nav class="nav-links">
      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/quizes">MyQuizes</RouterLink>
      <RouterLink to="/explore">Explore</RouterLink>
      <RouterLink to="/mystats">MyStats</RouterLink>
    </nav>

    <div class="account">
      ME
    </div>
  </header>
  <div :class="{'header-hidden-content' : $route.meta.hideHeader , 'content':!$route.meta.hideHeader}">
    <RouterView />
  </div>
</template>

<style scoped>
header{
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 50px;
  padding: 0px 16px;
  background-color: var(--dark-color);
  color: var(--lighter-color);
  margin: 8px;
  border-radius: 16px;
}

.nav-links{
  display: flex;
  gap: 16px;
}

.nav-links a{
  font-weight: 800;
  padding: 2px 6px;
}

.nav-links .router-link-active{
  color: var(--dark-color);
  background-color: var(--lighter-color);
  border-radius: 16px;
}

.logo{
  display: flex;
  align-items: center;
  height: 30px;
}

.search-wrapper{
  display: flex;
}

.search-wrapper input{
  all: unset;
  color: black;
  width: 128px;
  background-color: var(--lightest-color);
  padding: 0 8px 0 8px;
  border-radius: 16px 0 0 16px;
}

.search-logo{
  color: var(--dark-color);
  height: 30px;
  background-color: var(--lightest-color);
  padding-right: 4px;
  border-radius: 0 16px 16px 0;
}

.account{
  height: 30px;
  width: 30px;
  border: 1px solid var(--lightest-color);
  border-radius: 100%;
}

.header-hidden-content{
  background-color: var(--lighter-color);
  margin: 8px;
  border-radius: 8px;
  padding: 8px;
  min-height: calc(100vh - 16px);
}

.content{
  background-color: var(--lighter-color);
  margin: 8px;
  border-radius: 8px;
  padding: 8px;
  min-height: calc(100vh - 74px);
}
</style>
