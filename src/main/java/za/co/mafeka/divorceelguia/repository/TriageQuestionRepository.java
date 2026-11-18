package za.co.mafeka.divorceelguia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mafeka.divorceelguia.model.TriageQuestion;

import java.util.List;
import java.util.UUID;

public interface TriageQuestionRepository extends JpaRepository<TriageQuestion, UUID> {
    List<TriageQuestion> findByIsActiveTrueOrderByDisplayOrderAsc();
}
