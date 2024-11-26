<script>
import { RouterLink } from 'vue-router';
</script>

<template>
    <div class="form-wrapper">
        <form id="login-form">
        <h3>Login to your account</h3>
        <label for="name" required>Email</label>
        <input type="email" name="name" id="name">
        <label for="password">Password</label>
        <input type="password">
        <button>Login</button>
        <span>Don't have a account?</span>
        <RouterLink to="/signup">SignUp ></RouterLink>
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

#login-form{
    display: flex;
    flex-direction: column;
    background-color: var(--dark-color);
    color: var(--lightest-color);
    max-width: 500px;
    max-height: fit-content;
    padding: 32px;
    border-radius: 16px;
}

#login-form>h3{
    text-align: center;
    margin-bottom: 8px;
}

#login-form>input{
    background-color: var(--lightest-color);
    padding: 4px 8px;
    color: var(--dark-color);
    border-radius: 4px;
}

#login-form>input:focus{
    background-color: var(--lighter-color);
}

#login-form>button{
    background-color: var(--lighter-color);
    width: fit-content;
    padding: 4px 8px;
    border-radius: 16px;
    color: var(--dark-color);
    margin: 16px auto;
    cursor: pointer;
}

#login-form>button:hover{
    background-color: var(--light-color);
}

#login-form>span,a{
    display: block;
    margin: auto;
}

#login-form>a{
    text-decoration: underline;
    text-underline-offset: 4px;
}
</style>