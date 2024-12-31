package ma.youcode.surveyit.dto.response.edition;

import ma.youcode.surveyit.dto.response.chapter.ChapterEmbeddedDTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public record EditionEmbeddedDTO(
        Long id,
        LocalDateTime creationDate,
        LocalDateTime startDate,
        int year,
        List<ChapterEmbeddedDTO> chapters
) implements Serializable {
}
