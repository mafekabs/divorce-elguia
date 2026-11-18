package za.co.mafeka.divorceelguia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mafeka.divorceelguia.model.PhaseChecklistItem;

import java.util.List;
import java.util.UUID;

public interface PhaseChecklistItemRepository extends JpaRepository<PhaseChecklistItem, UUID> {
    List<PhaseChecklistItem> findByPhaseIdOrderBySortOrderAsc(UUID phaseId);
    List<PhaseChecklistItem> findByPhaseCodeOrderBySortOrderAsc(String phaseCode);
}
