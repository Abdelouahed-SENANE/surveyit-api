package ma.youcode.surveyit.dto.response.admin;

import ma.youcode.surveyit.dto.response.user.UserResponseDTO;

public record AdminResponseDTO(
    UserResponseDTO userInfo
) {
}
