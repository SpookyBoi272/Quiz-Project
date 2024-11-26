<script>
import { RouterLink } from 'vue-router';
</script>

<template>
    <div class="form-wrapper">
        <form id="signup-form">
        <h3>SignUp for an account</h3>
        <label for="name">Email</label>
        <input type="email" name="name" id="name">
        <label for="password">Password</label>
        <input type="password" id="password">
        <label for="confirm-password">Confirm Password</label>
        <input type="password" id="confirm-password">
        <button>SignUp</button>
        <span>Already have an account?</span>
        <RouterLink to="/login">Login ></RouterLink>
    </form>
    </div>
</template>

<style scoped>
.form-wrapper{
    width: 100%;
    min-height: calc(100vh - 32px);
    display: flex;
    align-items: center;
    justify-content: center;
}

#signup-form{
    display: flex;
    flex-direction: column;
    background-color: var(--dark-color);
    color: var(--lightest-color);
    max-width: 500px;
    max-height: fit-content;
    padding: 32px;
    border-radius: 16px;
}

#signup-form>h3{
    text-align: center;
    margin-bottom: 8px;
}

#signup-form>input{
    background-color: var(--lightest-color);
    padding: 4px 8px;
    color: var(--dark-color);
    border-radius: 4px;
}

#signup-form>input:focus{
    background-color: var(--lighter-color);
}

#signup-form>button{
    background-color: var(--lighter-color);
    width: fit-content;
    padding: 4px 8px;
    border-radius: 16px;
    color: var(--dark-color);
    margin: 16px auto;
    cursor: pointer;
}

#signup-form>button:hover{
    background-color: var(--light-color);
}

#signup-form>span,a{
    display: block;
    margin: auto;
}

#signup-form>a{
    text-decoration: underline;
    text-underline-offset: 4px;
}
</style>

