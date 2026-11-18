package za.co.mafeka.divorceelguia.dto.appointment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AppointmentDto(
        UUID id,

        @NotNull
        @JsonProperty("office-id")
        UUID officeId,

        @NotNull
        @JsonProperty("office-name")
        String officeName,

        @NotNull
        @JsonProperty("seeker-id")
        UUID seekerId,

        @NotNull
        @JsonProperty("date-time")
        LocalDateTime dateTime,

        @NotNull
        String notes,
        String status
) {}
