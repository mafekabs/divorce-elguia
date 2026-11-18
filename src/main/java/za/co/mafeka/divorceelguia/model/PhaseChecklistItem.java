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
@Table(name = "phase_checklist_items")
public class PhaseChecklistItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "phase_id")
    private DivorcePhase phase;

    private String title; // Bring ID
    private String description;

    @Column(name = "sort_order")
    private String sortOrder;

    @Builder.Default
    @Column(name = "is_required")
    private Boolean isRequired = true;
}
