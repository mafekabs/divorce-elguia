package za.co.mafeka.divorceelguia.dto.appointment;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record AppointmentResponse(
        @NotNull
        List<AppointmentDto> appointments
) {}