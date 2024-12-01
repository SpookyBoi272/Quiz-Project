<script setup>
import { ApiService } from '@/utils/api';
import { ref } from 'vue';


const quiz = ref({
  name: '',
  description: '',
  genre: '',
  questions: [
    {
      questionText: '',
      options: [
        {optionText: ''},
        {optionText: ''},
        {optionText: ''},
        {optionText: ''},
      ],
      correctOption: null
    },
  ]
})

const addQuestion = () =>{
  quiz.value.questions.push({
    questionText: '',
      options: [
        {optionText: ''},
        {optionText: ''},
        {optionText: ''},
        {optionText: ''},
      ],
      correctOption: null
  })
}

const removeQuestion = (index)=>{
  quiz.value.questions.splice(index,1)
}

const addOption = (questionIndex) =>{
  quiz.value.questions[questionIndex].options.push({text: ''});
}

const removeOption = (questionIndex,optionIndex)=>{
  if(quiz.value.questions[questionIndex].options.length <3){
    console.log("Less than two options are not allowed")
    return
  }
  quiz.value.questions[questionIndex].options.splice(optionIndex,1)
}


const submitQuiz = () => {

  const transformedData = {
  ...quiz.value, // Copy the top-level properties (name, description, genre)
  questions:quiz.value.questions.map((question) => ({
    questionText: question.questionText,
    options: question.options.map((option, index) => ({
      ...option,
      isCorrect: index === question.correctOption, // Add isCorrect based on correctOption index
    })),
  })),
};

console.log(transformedData)

ApiService.createQuiz(transformedData)
}

</script>

<template>
  <div class="quiz-container">
    <h1>Create a New Quiz</h1>

    <!-- Quiz Title -->
    <div class="form-group">
      <label for="quiz-name">Quiz Name:</label>
      <input type="text" id="quiz-name" v-model="quiz.name" placeholder="Enter quiz name" />
      <label for="quiz-desc">Description</label>
      <input type="text" id="quiz-desc" v-model="quiz.description" placeholder="Enter Description" />
      <label for="quiz-genre">Genre:</label>
      <select name="quiz-genre" id="quiz-genre" v-model="quiz.genre">
        <option value="maths">Maths</option>
        <option value="science">Science</option>
        <option value="technology">Technology</option>
        <option value="mixed">Mixed</option>
        <option value="other">Other</option>
      </select>
    </div>

    <!-- Questions List -->
    <div v-for="(question, index) in quiz.questions" :key="index" class="question-group">
      <h3>Question {{ index + 1 }}</h3>
      <div class="form-group">
        <label :for="'question-' + index">Question Text:</label>
        <input type="text" :id="'question-' + index" v-model="question.questionText" placeholder="Enter question" />
      </div>

      <!-- Options -->
      <div v-for="(option, optIndex) in question.options" :key="optIndex" class="option-group">
        <label :for="'option-' + index + '-' + optIndex">Option {{ optIndex + 1 }}:</label>
        <input type="text" :id="'option-' + index + '-' + optIndex" v-model="option.optionText"
          placeholder="Enter option text" />
        <label>
          <input type="radio" :name="'correct-' + index" :value="optIndex" v-model="question.correctOption" />
          Correct
        </label>
        <button @click="removeOption(index, optIndex)" class="dark">Remove Option</button>
      </div>
      <button @click="addOption(index)" class="dark">Add Option</button>
      

      <!-- Remove Question Button -->
      <button @click="removeQuestion(index)" class="remove-btn dark">Remove Question</button>
    </div>

    <!-- Add Question Button -->
    <button @click="addQuestion" class="add-btn dark">Add Question</button>

    <!-- Submit Button -->
    <button @click="submitQuiz" class="submit-btn dark">Submit Quiz</button>
  </div>
</template>

<style scoped>
.quiz-container {
  max-width: 600px;
  margin: auto;
}

.form-group {
  margin-bottom: 1rem;
}

label {
  display: block;
  font-weight: bold;
}

input[type='text'] {
  width: 100%;
  padding: 0.5rem;
  margin-bottom: 0.5rem;
}

.question-group,
.option-group {
  margin-bottom: 1rem;
}
</style>