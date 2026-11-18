package za.co.mafeka.divorceelguia.model;

import jakarta.persistence.*;
import lombok.*;
import za.co.mafeka.divorceelguia.model.enums.ReferralStatus;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "referrals")
public class Referral {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "triage_session_id")
    private TriageSession triageSession;

    @ManyToOne
    @JoinColumn(name = "from_office_id")
    private Office fromOffice;

    @ManyToOne
    @JoinColumn(name = "to_office_id")
    private Office toOffice;

    private String reason;

    @Column(unique = true)
    private String referralCode; // user shows this at office

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private ReferralStatus status = ReferralStatus.PENDING;
}