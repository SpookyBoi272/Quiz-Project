package prod.redshark.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prod.redshark.quiz.model.Question;

public interface QuestionRepository extends JpaRepository<Question , Long> {
}
