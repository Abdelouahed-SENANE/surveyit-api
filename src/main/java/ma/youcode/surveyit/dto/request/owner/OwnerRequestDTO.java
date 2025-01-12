package ma.youcode.surveyit.dto.request.owner;

import ma.youcode.surveyit.dto.request.user.UserRequestDTO;

import java.io.Serializable;

public record OwnerRequestDTO(
        UserRequestDTO userInfo
) implements Serializable {
}
