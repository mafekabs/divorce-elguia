package za.co.mafeka.divorceelguia.dto.PhaseChecklistItem;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PhaseChecklistItemDto(
        UUID id,
        UUID phaseId,

        @NotNull
        String title,

        @NotNull
        String description,

        @NotNull
        @JsonProperty("is-required")
        Boolean isRequired
) {}