package za.co.mafeka.divorceelguia.dto.faq;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FaqDto(
        UUID id,

        @JsonProperty("seeker-id")
        UUID phaseId,

        @NotNull
        String question,

        @NotNull
        String answer,

        @NotNull
        String language
) {}
