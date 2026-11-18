package za.co.mafeka.divorceelguia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mafeka.divorceelguia.model.LegalService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LegalServiceRepository extends JpaRepository<LegalService, UUID> {
    Optional<LegalService> findByCode(String code);
    List<LegalService> findByIsActiveTrue();
    List<LegalService> findByIsActiveTrueOrderBySortOrderAsc();
}