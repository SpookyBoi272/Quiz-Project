<script>
import { RouterLink, RouterView } from 'vue-router'
import {HomeIcon, MagnifyingGlassIcon} from '@heroicons/vue/16/solid'

export default {
  components: { HomeIcon, MagnifyingGlassIcon }
};
</script>

<template>
  <header>
    <div class="logo">
      <HomeIcon/>
    </div>
    <nav class="nav-links">
      <RouterLink to="/home">Home</RouterLink>
      <RouterLink to="/quizes">Quizes</RouterLink>
      <RouterLink to="/explore">Explore</RouterLink>
      <RouterLink to="/mystats">MyStats</RouterLink>
    </nav>
    <div class="search-wrapper">
      <input type="text" name="search" placeholder="Search">
      <div class="search-logo"><MagnifyingGlassIcon/></div>
    </div>
  </header>
  <div class="content">
    <RouterView />
  </div>
</template>

<style>
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

.content{
  background-color: var(--lighter-color);
  margin: 8px;
  border-radius: 8px;
  padding: 8px;
  min-height: calc(100vh - 74px);
}
</style>
