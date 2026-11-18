package za.co.mafeka.divorceelguia.model;

import jakarta.persistence.*;
import lombok.*;
import za.co.mafeka.divorceelguia.model.enums.OfficeType;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "offices")
public class Office {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String city;

    @Enumerated(EnumType.STRING)
    private OfficeType type;

    @Column(length = 2000)
    private String description;

    @Column(name = "what_they_do")
    private String whatTheyDo;

    @Column(name="what_they_dont_do")
    private String whatTheyDontDo;

    private String phone;
    private String whatsapp;

    @Column(name = "email_address")
    private String emailAddress;

    private String website;

    @Column(name = "address_line1")
    private String addressLine1;

    private String town;
    private String province;
    private Double gpsLat;
    private Double gpsLng;

    @Column(name = "operating_hours")
    private String operatingHours;

    @Column(name = "language_spoken")
    private String languagesSpoken; // comma separated: English,Sesotho

    @Column(name = "capacity_notes")
    private String capacityNotes; // e.g. Waiting 2-4 weeks

    @Builder.Default
    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "verified_at")
    private LocalDateTime verifiedAt;

    @Column(name = "verified_by")
    private String verifiedBy;

    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "office_services",
            joinColumns = @JoinColumn(name = "office_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<LegalService> legalServices = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "office")
    private List<Appointment> appointments = new ArrayList<>();
}