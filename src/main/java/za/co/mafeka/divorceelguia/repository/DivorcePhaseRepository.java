package za.co.mafeka.divorceelguia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mafeka.divorceelguia.model.DivorcePhase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

interface DivorcePhaseRepository extends JpaRepository<DivorcePhase, UUID> {
    Optional<DivorcePhase> findByCode(String code);
    List<DivorcePhase> findByIsActiveTrueOrderBySortOrderAsc();
}