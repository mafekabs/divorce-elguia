package za.co.mafeka.divorceelguia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mafeka.divorceelguia.model.TriageAnswerOption;

import java.util.List;
import java.util.UUID;

public interface TriageAnswerOptionRepository extends JpaRepository<TriageAnswerOption, UUID> {
    List<TriageAnswerOption> findByQuestionIdOrderBySortOrderAsc(UUID questionId);
}
