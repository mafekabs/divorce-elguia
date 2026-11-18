package za.co.mafeka.divorceelguia.dto.deadline;

import java.time.LocalDate;

public record CalculateDeadlineResponse(
        LocalDate summonsServedDate,
        String deadlineType,
        LocalDate dueDate,
        Integer courtDays,
        String explanation // e.g. 10 court days, excluding weekends + holidays
) {}
