<template>
    <div class="wrapper">
        <div class="error-logo">
        <ShieldExclamationIcon />
    </div>
    <h1 class="heading">Page not found </h1>
    <router-link class="home-link" to="/">Go to Home</router-link>
    </div>
</template>

<script>
import { ShieldExclamationIcon } from '@heroicons/vue/24/solid';

export default {
    components: { ShieldExclamationIcon }
}
</script>

<style scoped>
.wrapper {
    min-height: calc(100vh - 90px);
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    text-align: center;
}

.error-logo {
    height: 30vh;
    width: 30vh;
    color: var(--dark-color);
}

.heading {
    color: #000;
    font-size: 2rem;
    margin-top: 16px;
}

.home-link {
    width: fit-content;
    font-weight: 800;
    padding: 4px 16px;
    margin-top: 16px;
    color: var(--lighter-color);
    background-color: var(--dark-color);
    border-radius: 16px;
}
</style>