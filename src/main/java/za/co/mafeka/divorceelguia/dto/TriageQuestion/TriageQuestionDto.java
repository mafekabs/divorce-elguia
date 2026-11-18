package za.co.mafeka.divorceelguia.dto.TriageQuestion;

import za.co.mafeka.divorceelguia.dto.TriageAnswerOption.TriageAnswerOptionDto;

import java.util.List;
import java.util.UUID;

public record TriageQuestionDto(
        UUID id,
        String code,
        String questionTextEn,
        String questionTextSesotho,
        String questionType,
        Integer displayOrder,
        List<TriageAnswerOptionDto> options
) {}
