package ma.youcode.surveyit.dto.response.question;

import ma.youcode.surveyit.enums.QuestionType;

import java.io.Serializable;

public record QuestionEmbeddedDTO(
        Long id,
        String text,
        QuestionType type,
        int answerCount
) implements Serializable {
}
