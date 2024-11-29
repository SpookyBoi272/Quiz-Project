package prod.redshark.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prod.redshark.quiz.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz , Long> {

}
