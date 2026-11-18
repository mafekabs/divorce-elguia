package za.co.mafeka.divorceelguia.dto.seekerprofile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SeekerProfileDto(
        UUID id,
        UUID userId,

        @NotNull
        @JsonProperty("monthly-income")
        String monthlyIncome,

        @NotNull
        @NotNull
        @JsonProperty("employment-status")
        String employmentStatus,

        @NotNull
        @JsonProperty("has-minor-children")
        Boolean hasMinorChildren,

        @NotNull
        @JsonProperty("marriage-type")
        String marriageType,

        @JsonProperty("current-phase")
        String currentPhase,

        @NotNull
        @JsonProperty("has-court-date")
        Boolean hasCourtDate,

        @JsonProperty("monthly-income")
        LocalDate courtDate
) {}