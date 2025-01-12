package ma.youcode.surveyit.dto.response.login;

import ma.youcode.surveyit.constant.RoleName;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public record LoginResponseDTO(
        String token,
        long expiredIn,
        Collection<? extends GrantedAuthority> authorities
) {
}
