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
@Table(name = "faqs")
public class Faq {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "phase_id")
    private DivorcePhase phase;

    private String question;

    private String category;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(length = 5000)
    private String answer;

    @Column(name = "sort_order")
    private String sortOrder;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Language language = Language.ENGLISH;
}
