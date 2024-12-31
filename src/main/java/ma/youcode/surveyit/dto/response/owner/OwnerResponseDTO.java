package ma.youcode.surveyit.dto.response.owner;

import ma.youcode.surveyit.dto.response.survey.SurveyEmbeddedDTO;

import java.io.Serializable;
import java.util.List;

public record OwnerResponseDTO(Long id , String name , List<SurveyEmbeddedDTO> surveys) implements Serializable {}
