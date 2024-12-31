package ma.youcode.surveyit.dto.response.edition;

import ma.youcode.surveyit.dto.response.chapter.ChapterEmbeddedDTO;
import ma.youcode.surveyit.dto.response.survey.SurveyCustomDTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


public record EditionResponseDTO(
                          Long id,
                          LocalDateTime creationDate,
                          LocalDateTime startDate,
                          int year,
                          SurveyCustomDTO survey,
                          List<ChapterEmbeddedDTO> chapters
) implements Serializable {
}
