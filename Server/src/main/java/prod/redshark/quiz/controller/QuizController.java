package prod.redshark.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prod.redshark.quiz.model.Option;
import prod.redshark.quiz.model.Question;
import prod.redshark.quiz.model.Quiz;
import prod.redshark.quiz.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping
    public Page<Quiz> getAllQuizzes(@RequestParam(defaultValue = "0") int page, @RequestParam (defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page-1,size);



        return quizService.getAllQuizzes(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        quiz.getQuestions().get(0).getOptions().forEach(option -> {
            System.out.println(option.isCorrect());
        });

        for (Question question : quiz.getQuestions()) {
            question.setQuiz(quiz);
            for (Option option : question.getOptions()) {
                option.setQuestion(question);
            }
        }

        Quiz createdQuiz = quizService.createQuiz(quiz);


        return ResponseEntity.ok(createdQuiz);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.noContent().build();
    }
}
