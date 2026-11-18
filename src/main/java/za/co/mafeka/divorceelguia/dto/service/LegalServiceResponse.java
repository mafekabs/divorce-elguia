package za.co.mafeka.divorceelguia.dto.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record LegalServiceResponse(
        @NotNull
        @JsonProperty("legalServices")
        List<LegalServiceDto> legalServices
) {}