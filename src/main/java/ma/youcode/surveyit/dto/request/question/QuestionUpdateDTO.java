package ma.youcode.surveyit.dto.request.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import ma.youcode.surveyit.annotation.interfaces.Exists;
import ma.youcode.surveyit.constant.QuestionType;
import ma.youcode.surveyit.entity.Chapter;

import java.io.Serializable;

public record QuestionUpdateDTO
        (
                @NotEmpty
                String text,
                @NotEmpty
                QuestionType type,
                @NotNull
                int answerCount,
                @Exists(entity = Chapter.class , message = "Subchapter not found.")
                Long subchapterId
        )

        implements Serializable {
}
