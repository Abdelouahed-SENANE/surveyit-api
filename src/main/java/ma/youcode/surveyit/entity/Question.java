package ma.youcode.surveyit.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youcode.surveyit.enums.QuestionType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @Column(name = "question_text")
    private String text;

    @Enumerated(EnumType.STRING)
    @Column(name = "question_type")
    private QuestionType type;

    @JoinColumn(name = "answer_count")
    private int answerCount;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter subchapter;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();


}
