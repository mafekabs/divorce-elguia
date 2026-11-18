package za.co.mafeka.divorceelguia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mafeka.divorceelguia.model.Guide;

import java.util.List;
import java.util.UUID;

public interface GuideRepository extends JpaRepository<Guide, UUID> {
    List<Guide> findByIsActiveTrue();
    List<Guide> findByPhaseIdAndIsActiveTrue(UUID phaseId);
    List<Guide> findByPhaseCodeAndIsActiveTrue(String phaseCode);
    List<Guide> findByIsActiveTrueOrderByTitleAsc();
}