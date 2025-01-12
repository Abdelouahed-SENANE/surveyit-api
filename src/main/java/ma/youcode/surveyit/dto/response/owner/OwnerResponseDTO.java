package ma.youcode.surveyit.dto.response.owner;

import ma.youcode.surveyit.dto.response.survey.SurveyEmbeddedDTO;
import ma.youcode.surveyit.dto.response.user.UserResponseDTO;

import java.io.Serializable;
import java.util.List;

public record OwnerResponseDTO(UserResponseDTO userInfo, List<SurveyEmbeddedDTO> surveys) implements Serializable {}
