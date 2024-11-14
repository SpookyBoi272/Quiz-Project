<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <div class="wrapper">
      
      <nav>
        <RouterLink title="Home" to="/">Home</RouterLink>
        <RouterLink title="About" to="/about">About</RouterLink>
      </nav>

    </div>
  </header>

  <RouterView />
</template>

<style scoped>

</style>
