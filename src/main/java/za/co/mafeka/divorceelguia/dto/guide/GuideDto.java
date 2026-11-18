package za.co.mafeka.divorceelguia.dto.guide;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GuideDto(
        UUID id,
        UUID phaseId,

        @NotNull
        String slug,

        @NotNull
        String title,

        @NotNull
        String body,

        @NotNull
        String language,

        @NotNull
        @JsonProperty("read-time-minutes")
        Integer readTimeMinutes
) {}
