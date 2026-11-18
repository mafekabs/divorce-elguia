package za.co.mafeka.divorceelguia.model;

import jakarta.persistence.*;
import lombok.*;
import za.co.mafeka.divorceelguia.model.enums.QuestionType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "triage_questions")
public class TriageQuestion {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String code; // Q1_PHASE, Q2_CHILDREN

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "question_text_en")
    private String questionTextEn;

    @Column(name = "question_text_sesotho")
    private String questionTextSesotho;

    @Column(name = "question_type")
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @Column(name = "display_order")
    private Integer displayOrder;

    @Builder.Default
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<TriageAnswerOption> options = new ArrayList<>();
}
