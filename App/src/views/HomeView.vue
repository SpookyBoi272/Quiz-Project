<script setup>
import {ref,onMounted} from 'vue';

const img_url = ref('')
const host = "http://localhost:8080"
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
    <img :src="img_url" alt="Image ID 1">
  </h1>
</template>
