package za.co.mafeka.divorceelguia.model;

import jakarta.persistence.*;
import lombok.*;
import za.co.mafeka.divorceelguia.model.enums.DeadlineType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "deadlines")
public class Deadline {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private DivorceCase divorceCase;

    @Enumerated(EnumType.STRING)
    private DeadlineType type; // NOTICE_TO_DEFEND, PLEA

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Builder.Default
    @Column(name = "is_completed")
    private Boolean isCompleted = false;

    @Column(name = "complete_at")
    private LocalDateTime completedAt;

    @Builder.Default
    @Column(name="reminder_sent")
    private Boolean reminderSent = false;
}
