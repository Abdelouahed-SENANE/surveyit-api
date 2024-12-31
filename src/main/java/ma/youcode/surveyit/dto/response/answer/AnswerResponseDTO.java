package ma.youcode.surveyit.dto.response.answer;

import ma.youcode.surveyit.dto.response.question.QuestionEmbeddedDTO;

import java.io.Serializable;


public record AnswerResponseDTO(
        Long id,
        String text,
        int selectionCount,
        QuestionEmbeddedDTO question
) implements Serializable { }
