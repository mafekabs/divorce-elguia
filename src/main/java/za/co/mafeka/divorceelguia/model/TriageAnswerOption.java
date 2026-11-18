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
@Table(name = "triage_answer_options")
public class TriageAnswerOption {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private TriageQuestion question;

    private String sortOrder;
    private String label;
    private String value;

    @Column(name = "next_question_code")
    private String nextQuestionCode; // code of next question
}
