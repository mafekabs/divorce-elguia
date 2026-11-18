package za.co.mafeka.divorceelguia.dto.office;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record OfficeRequest(
        @NotNull
        OfficeDto office
) {}
