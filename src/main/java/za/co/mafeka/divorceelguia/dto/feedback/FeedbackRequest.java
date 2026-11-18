package za.co.mafeka.divorceelguia.dto.feedback;

import jakarta.validation.constraints.NotNull;

public record FeedbackRequest(
        @NotNull
        FeedbackDto feedback
) {}
