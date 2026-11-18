package za.co.mafeka.divorceelguia.model;

import jakarta.persistence.*;
import lombok.*;
import za.co.mafeka.divorceelguia.model.enums.Language;
import za.co.mafeka.divorceelguia.model.enums.Role;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "user_name")
    private String userName;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="mobile_number")
    private String mobileNumber;

    @Column(name="email_address", nullable = false)
    private String emailAddress;

    @Convert(converter = EncryptedStringConverter.class)
    @Column(name = "id_number")
    private String idNumber; // ENCRYPTED - never plain text

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Role role = Role.SEEKER;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Language preferredLanguage = Language.ENGLISH;

    @Column(nullable = false)
    private String province;

    @Column(nullable = false)
    private String town;

    @Builder.Default
    @Column(name="created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private SeekerProfile seekerProfile;
}