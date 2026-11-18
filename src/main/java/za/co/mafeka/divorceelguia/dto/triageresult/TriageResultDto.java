package za.co.mafeka.divorceelguia.dto.triageresult;

import za.co.mafeka.divorceelguia.dto.office.OfficeDto;

import java.util.List;

public record TriageResultDto(
        String sessionId,
        String eligibility,        // LIKELY_QUALIFIES, MAYBE, DOES_NOT_QUALIFY
        OfficeDto recommendedOffice,
        List<OfficeDto> alternativeOffices,
        List<String> whatToBring,  // checklist for Angular
        String warningMessage,     // e.g. Your 10 days started...
        String referralCode,
        String whatsappShareText
) {}
