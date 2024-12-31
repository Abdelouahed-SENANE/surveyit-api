package ma.youcode.surveyit.dto.response.survey;

import java.io.Serializable;

public record SurveyCustomDTO(
                            Long id,
                            String title,
                            String description
) implements Serializable {
}
