package za.co.mafeka.divorceelguia.dto.referral;

import java.util.UUID;

public record CreateReferralRequest(
        UUID triageSessionId,
        UUID fromOfficeId,
        UUID toOfficeId,
        String reason
) {}
