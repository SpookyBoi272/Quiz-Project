package prod.redshark.quiz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class QuizController {

    @PostMapping("/quiz/create")
    public ResponseEntity<Integer> createNewQuiz(){
        return ResponseEntity.ok(200);
    }
}
