package za.co.mafeka.divorceelguia.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "triage_rules")
public class TriageRule {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID targetServiceId;
    private String name; // e.g. LOW_INCOME_SUMMONS -> LEGAL_AID
    private String condition; // e.g. income<14500 AND phase=SUMMONS

    @Column(name = "recommend_office_type")
    private String recommendOfficeType; // LEGAL_AID

    @Builder.Default
    private Integer priority = 1;

    @Builder.Default
    @Column(name = "is_active")
    private Boolean isActive = true;
}