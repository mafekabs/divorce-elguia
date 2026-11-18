package za.co.mafeka.divorceelguia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mafeka.divorceelguia.model.TriageRule;

import java.util.List;
import java.util.UUID;

public interface TriageRuleRepository extends JpaRepository<TriageRule, UUID> {
    List<TriageRule> findByIsActiveTrueOrderByPriorityAsc();
    List<TriageRule> findByTargetServiceIdAndIsActiveTrue(UUID targetServiceId);
}
