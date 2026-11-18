package za.co.mafeka.divorceelguia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mafeka.divorceelguia.model.DivorceCase;

import java.util.List;
import java.util.UUID;

public interface DivorceCaseRepository extends JpaRepository<DivorceCase, UUID> {
    List<DivorceCase> findBySeekerIdOrderByCreatedAtDesc(UUID seekerId);
    List<DivorceCase> findByOfficeId(UUID officeId);
    List<DivorceCase> findByStatus(String status);
    List<DivorceCase> findBySeekerIdAndStatus(UUID seekerId, String status);
}