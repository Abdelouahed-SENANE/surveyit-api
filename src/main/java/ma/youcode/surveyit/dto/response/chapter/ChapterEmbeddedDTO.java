package ma.youcode.surveyit.dto.response.chapter;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.youcode.surveyit.dto.response.question.QuestionEmbeddedDTO;
import ma.youcode.surveyit.dto.response.question.QuestionResponseDTO;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChapterEmbeddedDTO(
                            Long id,
                            String title,
                            List<ChapterEmbeddedDTO> subchapters,
                            List<QuestionResponseDTO> questions

) implements Serializable {
}
