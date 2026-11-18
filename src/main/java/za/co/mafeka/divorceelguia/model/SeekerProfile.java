package za.co.mafeka.divorceelguia.model;

import jakarta.persistence.*;
import lombok.*;
import za.co.mafeka.divorceelguia.model.enums.EmploymentStatus;
import za.co.mafeka.divorceelguia.model.enums.IncomeBracket;
import za.co.mafeka.divorceelguia.model.enums.MarriageType;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "seeker_profiles")
public class SeekerProfile {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private IncomeBracket monthlyIncome = IncomeBracket.UNKNOWN;

    @Enumerated(EnumType.STRING)
    private EmploymentStatus employmentStatus;

    @Column(name = "has_minor_children")
    private Boolean hasMinorChildren;

    @Column(name = "current_phase")
    private String currentPhase; // PHASE_0 to PHASE_7

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private MarriageType marriageType = MarriageType.UNKNOWN;

    @Column(name = "has_court_date")
    private Boolean hasCourtDate;

    @Column(name = "court_date", nullable = false)
    private LocalDate courtDate;

    private String city;

    private String province;
}