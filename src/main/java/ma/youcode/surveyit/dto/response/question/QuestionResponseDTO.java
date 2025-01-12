package ma.youcode.surveyit.dto.response.question;

import ma.youcode.surveyit.constant.QuestionType;
import ma.youcode.surveyit.dto.response.answer.AnswerResponseDTO;
import ma.youcode.surveyit.dto.response.chapter.ChapterCustomDTO;

import java.io.Serializable;
import java.util.List;


public record QuestionResponseDTO(
        Long id,
        String text,
        QuestionType type,
        int answerCount,
        ChapterCustomDTO subchapter,
        List<AnswerResponseDTO> answers
) implements Serializable { }
