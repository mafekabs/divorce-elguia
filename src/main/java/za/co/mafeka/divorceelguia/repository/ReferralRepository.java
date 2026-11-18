package za.co.mafeka.divorceelguia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mafeka.divorceelguia.model.Referral;

import java.util.List;
import java.util.UUID;

public interface ReferralRepository extends JpaRepository<Referral, UUID> {
    List<Referral> findByTriageSessionId(UUID triageSessionId);
    List<Referral> findByFromOfficeId(UUID officeId);
    List<Referral> findByToOfficeId(UUID officeId);
    List<Referral> findByStatus(String status);
    List<Referral> findByToOfficeIdAndStatus(UUID officeId, String status);
}
