package ma.youcode.surveyit.dto.response.chapter;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.youcode.surveyit.dto.response.edition.EditionCustomDTO;
import ma.youcode.surveyit.dto.response.question.QuestionEmbeddedDTO;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChapterResponseDTO(
        Long id,
        String title,
        EditionCustomDTO edition,
        List<ChapterResponseDTO> subchapters,
        List<QuestionEmbeddedDTO> questions

) implements Serializable {
}
