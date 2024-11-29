package prod.redshark.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prod.redshark.quiz.model.Option;

public interface OptionRepository extends JpaRepository<Option , Long> {
}
