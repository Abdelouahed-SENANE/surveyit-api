package ma.youcode.surveyit.dto.request.admin;

import ma.youcode.surveyit.dto.request.user.UserRequestDTO;

public record AdminRequestDTO(
    UserRequestDTO userInfo
) {
}
