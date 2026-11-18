package za.co.mafeka.divorceelguia.dto.deadline;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DeadlineDto(
        UUID id,

        @JsonProperty("case-id")
        UUID caseId,
        String type, // NOTICE_TO_DEFEND, PLEA

        @NotNull
        @JsonProperty("due-date")
        LocalDate dueDate,

        @NotNull
        @JsonProperty("is-completed")
        Boolean isCompleted,

        @NotNull
        @JsonProperty("completed-at")
        LocalDateTime completedAt,

        @NotNull
        @JsonProperty("reminder-sent")
        Boolean reminderSent,

        @NotNull
        @JsonProperty("days-remaining")
        Integer daysRemaining // calculated for Angular
) {}
