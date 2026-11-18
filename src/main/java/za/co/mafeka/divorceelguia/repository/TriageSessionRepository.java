package za.co.mafeka.divorceelguia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mafeka.divorceelguia.model.TriageSession;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TriageSessionRepository extends JpaRepository<TriageSession, UUID> {
    List<TriageSession> findBySeekerIdOrderByCreatedAtDesc(UUID seekerId);
    List<TriageSession> findBySeekerId(UUID seekerId);
}
