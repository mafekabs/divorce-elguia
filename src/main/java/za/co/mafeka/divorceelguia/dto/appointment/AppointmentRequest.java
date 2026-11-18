package za.co.mafeka.divorceelguia.dto.appointment;

import jakarta.validation.constraints.NotNull;

public record AppointmentRequest(
        @NotNull
        AppointmentDto appointment
) {}