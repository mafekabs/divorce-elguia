package za.co.mafeka.divorceelguia.dto.publicholiday;

import java.time.LocalDate;
import java.util.UUID;

public record PublicHolidayDto(
        UUID id,
        LocalDate date,
        String name
) {}
