package za.co.mafeka.divorceelguia.dto.divorcecase;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import za.co.mafeka.divorceelguia.dto.deadline.DeadlineDto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DivorceCaseDto(
        UUID id,

        @NotNull
        @JsonProperty("seeker-id")
        UUID seekerId,

        @NotNull
        @JsonProperty("office-id")
        UUID officeId,

        @NotNull
        @JsonProperty("office-name")
        String officeName,

        @NotNull
        @JsonProperty("case-number")
        String caseNumber,

        @NotNull
        @JsonProperty("court-name")
        String courtName,

        @NotNull
        @JsonProperty("summons-served-date")
        LocalDate summonsServedDate,

        @NotNull
        String status,

        @NotNull
        @JsonProperty("is-plaintiff")
        Boolean isPlaintiff,

        @NotNull
        @JsonProperty("dead-lines")
        List<DeadlineDto> deadlines
) {}