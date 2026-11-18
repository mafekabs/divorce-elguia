package za.co.mafeka.divorceelguia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mafeka.divorceelguia.model.Deadline;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface DeadlineRepository extends JpaRepository<Deadline, UUID> {
    List<Deadline> findByDivorceCaseIdOrderByDueDateAsc(UUID caseId);
    List<Deadline> findByDivorceCaseIdAndIsCompletedFalseOrderByDueDateAsc(UUID caseId);
    List<Deadline> findByDueDateBetweenAndIsCompletedFalse(LocalDate start, LocalDate end);
    List<Deadline> findByIsCompletedFalseOrderByDueDateAsc();
}