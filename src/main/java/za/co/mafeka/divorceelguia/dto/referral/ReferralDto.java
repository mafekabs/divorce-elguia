package za.co.mafeka.divorceelguia.dto.referral;

import java.util.UUID;

public record ReferralDto(
        UUID id,
        UUID triageSessionId,
        UUID fromOfficeId,
        String fromOfficeName,
        UUID toOfficeId,
        String toOfficeName,
        String reason,
        String referralCode,
        String status
) {}
