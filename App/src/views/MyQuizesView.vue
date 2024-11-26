<script setup>
import { ref } from 'vue';


const quiz = ref({
    name: "",
    desc: "",
    genre: "",
});


const createNewQuiz = ()=>{
    console.log(quiz.value.name)
}

</script>

<template>
    <div class="main">

        <form action="">
            <label for="name">Name</label>
            <input v-model="quiz.name" type="text" id="name">
            <label for="description">Description</label>
            <input v-model="quiz.desc" type="text" id="description">
            <label for="genre">Genre</label>
            <select v-model="quiz.genre" name="genre" id="genre">
                <option value="">Select a Genre</option>
                <option value="science">Science</option>
                <option value="math">Maths</option>
                <option value="geography">Geography</option>
                <option value="movies">Movies</option>
                <option value="technology">Technology</option>
                <option value="mixed">Mixed</option>
            </select>
            <button class="dark" v-on:click.prevent="createNewQuiz">Done</button>
        </form>
    </div>
</template>

<style scoped>
form{
    display: flex;
    flex-direction: column;
}

</style>