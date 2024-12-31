package ma.youcode.surveyit.dto.response.answer;

import java.io.Serializable;

public record AnswerEmbeddedDTO(
        Long id,
        String text,
        int selectionCount
) implements Serializable {
}
