package za.co.mafeka.divorceelguia.dto.office;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record OfficeResponse(
        @NotNull
        List<OfficeDto> offices
) {}
