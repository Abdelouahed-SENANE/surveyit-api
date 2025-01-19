package ma.youcode.surveyit.service.implementations;

import lombok.RequiredArgsConstructor;
import ma.youcode.surveyit.constant.RoleName;
import ma.youcode.surveyit.dto.request.login.LoginRequestDTO;
import ma.youcode.surveyit.dto.request.user.UserRequestDTO;
import ma.youcode.surveyit.dto.response.login.LoginResponseDTO;
import ma.youcode.surveyit.security.jwt.JWTGenerator;
import ma.youcode.surveyit.service.interfaces.AuthService;
import ma.youcode.surveyit.service.interfaces.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JWTGenerator jwtGenerator;

    @Override
    public LoginResponseDTO authenticate(LoginRequestDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password()));
        String token = jwtGenerator.generateToken(authentication);
        long tokenExp = jwtGenerator.getExpirationTime();
        return new LoginResponseDTO(token, tokenExp ,getRoles(authentication.getAuthorities()));
    }

    private List<RoleName> getRoles(Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream()
                .map(authority -> RoleName.valueOf(authority.getAuthority()))
                .toList();
    }

    @Override
    public LoginResponseDTO register(UserRequestDTO userDTO) {
        userService.create(userDTO);
        return authenticate(new LoginRequestDTO(userDTO.email(), userDTO.password()));
    }

    @Override
    public void logout(String token) {

    }
}
