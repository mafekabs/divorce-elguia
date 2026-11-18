package za.co.mafeka.divorceelguia.model;

import jakarta.persistence.*;
import lombok.*;
import za.co.mafeka.divorceelguia.model.enums.CaseStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "divorce_cases")
public class DivorceCase {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private SeekerProfile seeker;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

    @Column(name="case_number")
    private String caseNumber;

    @Column(name="court_name")
    private String courtName; // HIGH_COURT_BLOEMFONTEIN

    @Column(name="summons_service_date", nullable = false)
    private LocalDate summonsServedDate;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private CaseStatus status = CaseStatus.ACTIVE;

    @Column(name = "is_plaintiff")
    private Boolean isPlaintiff; // true = I filed, false = I was served

    @Builder.Default
    @OneToMany(mappedBy = "divorceCase", cascade = CascadeType.ALL)
    private List<Deadline> deadlines = new ArrayList<>();

    @Builder.Default
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
