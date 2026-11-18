package za.co.mafeka.divorceelguia.model;

import jakarta.persistence.*;
import lombok.*;
import za.co.mafeka.divorceelguia.model.enums.Eligibility;
import za.co.mafeka.divorceelguia.model.enums.IncomeBracket;
import za.co.mafeka.divorceelguia.model.enums.MarriageType;
import za.co.mafeka.divorceelguia.model.enums.Urgency;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "triage_sessions")
public class TriageSession {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "session_id", unique = true)
    private String sessionId; // for share link / WhatsApp

    @Column(name = "seeker_id")
    private UUID seekerId;

    @Builder.Default
    @Column(name = "problem_type")
    private String problemType = "DIVORCE";

    @Column(name = "current_phase")
    private String currentPhase; // PHASE_2_SUMMONS etc

    @Column(name = "income_bracket")
    @Enumerated(EnumType.STRING)
    private IncomeBracket incomeBracket;

    @Column(name="marriage_type")
    @Enumerated(EnumType.STRING)
    private MarriageType marriageType;

    @Column(name = "has_children")
    private Boolean hasChildren;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    @ManyToOne
    @JoinColumn(name = "result_office_id")
    private Office resultOffice;

    @Column(name = "result_eligibility")
    @Enumerated(EnumType.STRING)
    private Eligibility resultEligibility;

    @Builder.Default
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "completed_at")
    private LocalDateTime completedAt;
}