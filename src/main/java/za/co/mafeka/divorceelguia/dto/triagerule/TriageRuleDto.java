package za.co.mafeka.divorceelguia.dto.triagerule;

import java.util.UUID;

public record TriageRuleDto(
        UUID id,
        String name,
        String condition,
        String recommendOfficeType,
        Integer priority,
        Boolean isActive
) {}
