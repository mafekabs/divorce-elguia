package za.co.mafeka.divorceelguia.dto.TriageAnswerOption;

import java.util.UUID;

public record TriageAnswerOptionDto(
        UUID id,
        String label,
        String value,
        String nextQuestionCode
) {}
