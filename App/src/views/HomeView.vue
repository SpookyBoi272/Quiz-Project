<script setup>
import {ref,onMounted} from 'vue';

const img_url = ref('')
const host = import.meta.env.VITE_API_BASE_URL
onMounted(()=>{
  fetch(host+"/api/v1/images/1")
  .then((res)=>{ return res.text()})
  .then((data)=>{
    img_url.value = data
    console.log(data)
  })
  .catch((err)=>{
    console.log("Error Fetching image url")
  })
});
</script>

<template>
  <h1>
    This is Home page.
  </h1>
  <img class="image-1" :src="img_url" alt="Image ID 1">
</template>

<style>
.image-1{
  height: 100px;
  width: 100px;
  border: 1px solid var(--dark-color);
}
</style>
