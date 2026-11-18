package za.co.mafeka.divorceelguia.dto.divorcecase;

import jakarta.validation.constraints.NotNull;

public record DivorceCaseRequest(
        @NotNull
        DivorceCaseDto divorceCase
) {}
