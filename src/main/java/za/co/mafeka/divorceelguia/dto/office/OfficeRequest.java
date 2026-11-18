package za.co.mafeka.divorceelguia.dto.office;

import jakarta.validation.constraints.NotNull;

public record OfficeRequest(
        @NotNull
        OfficeDto office
) {}
