const API_BASE_URL = import.meta.env.API_BASE_URL || "http://localhost:8080"

async function fetchAPI(endpoint, options = {}) {
    const response = await fetch(`${API_BASE_URL}${endpoint}` , {
        headers:{
            "Content-Type" : "application/json",
            ...options.headers,
        },
        ...options,
    });

    if(!response.ok){
        const error = await response.json();
        throw new Error(error.message || "API Error")
    }

    return response.json();
}

export const ApiService = {
    createQuiz(data){
        return fetchAPI("/api/v1/quizzes" , {
            method: "POST",
            body: JSON.stringify(data),
        });
    },
    getAllQuiz(){
        return fetchAPI("/api/v1/quizzes")
    },
    getQuiz(id){
        return fetchAPI(`/api/v1/quizzes/${id}`)
    }
};