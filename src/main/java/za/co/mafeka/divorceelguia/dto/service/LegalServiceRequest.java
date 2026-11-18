package za.co.mafeka.divorceelguia.dto.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record LegalServiceRequest(
        @NotNull
        @JsonProperty("service")
        LegalServiceDto service
) {}