package za.co.mafeka.divorceelguia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mafeka.divorceelguia.model.DivorcePhase;
import za.co.mafeka.divorceelguia.model.Faq;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FaqRepository extends JpaRepository<Faq, UUID> {
    List<Faq> findByIsActiveTrueOrderBySortOrderAsc();
    List<Faq> findByPhaseIdAndIsActiveTrueOrderBySortOrderAsc(UUID phaseId);
    List<Faq> findByPhaseCodeAndIsActiveTrueOrderBySortOrderAsc(String phaseCode);
    List<Faq> findByCategoryAndIsActiveTrueOrderBySortOrderAsc(String category);
}
