package za.co.mafeka.divorceelguia.model;

import jakarta.persistence.*;
import lombok.*;
import za.co.mafeka.divorceelguia.model.enums.Language;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "guides")
public class Guide {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "phase_id")
    private DivorcePhase phase;

    @Column(unique = true)
    private String slug; // what-happens-after-summons

    private String title;

    @Column(length = 20000)
    private String body; // Markdown

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Language language = Language.ENGLISH;

    @Column(name = "read_time_minutes")
    private Integer readTimeMinutes;
}