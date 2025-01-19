package ma.youcode.surveyit.dto.response.login;

import ma.youcode.surveyit.constant.RoleName;

import java.util.List;

public record LoginResponseDTO(
        String token,
        long expiredIn,
        List<RoleName> roles
) {
}
