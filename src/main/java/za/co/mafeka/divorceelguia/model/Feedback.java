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
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "triage_session_id")
    private TriageSession triageSession;

    private Integer rating;

    @Column(name = "was_helpful")
    private Boolean wasHelpful;

    private String comment;
}