package za.co.mafeka.divorceelguia.dto.deadline;

import java.time.LocalDate;

public record CalculateDeadlineRequest(
        LocalDate summonsServedDate,
        String deadlineType // NOTICE_TO_DEFEND or PLEA
) {}
