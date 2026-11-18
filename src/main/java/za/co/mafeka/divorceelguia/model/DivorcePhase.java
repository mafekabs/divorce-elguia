package za.co.mafeka.divorceelguia.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "divorce_phases")
public class DivorcePhase {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String code; // PHASE_0_THINKING ... PHASE_7_AFTER

    private String title;
    private String summary;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "sort_order")
    private String sortOrder;

    @Column(name = "what_happens", length = 5000)
    private String whatHappens;

    @Column(name = "how_long")
    private String howLong;

    @Column(name = "common_mistakes")
    private String commonMistakes;

    @Column(name = "display_order")
    private Integer displayOrder;

    @Builder.Default
    @OneToMany(mappedBy = "phase", cascade = CascadeType.ALL)
    private List<PhaseChecklistItem> checklist = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "phase", cascade = CascadeType.ALL)
    private List<Guide> guides = new ArrayList<>();
}
