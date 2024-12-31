package ma.youcode.surveyit.dto.response.survey;

import ma.youcode.surveyit.dto.response.edition.EditionEmbeddedDTO;

import java.io.Serializable;
import java.util.List;

public record SurveyEmbeddedDTO(
                            Long id,
                            String title,
                            String description,
                            List<EditionEmbeddedDTO> editions
) implements Serializable {
}
