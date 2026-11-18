package za.co.mafeka.divorceelguia.dto.feedback;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FeedbackDto(
        UUID id,

        @JsonProperty("triage-session-id")
        UUID triageSessionId,

        @NotNull
        @JsonProperty("was-helpful")
        Boolean wasHelpful,

        @NotNull
        String comment
) {}
