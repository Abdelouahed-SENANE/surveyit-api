package ma.youcode.surveyit.service.interfaces;

import ma.youcode.surveyit.dto.request.login.LoginRequestDTO;
import ma.youcode.surveyit.dto.request.user.UserRequestDTO;
import ma.youcode.surveyit.dto.response.login.LoginResponseDTO;

public interface AuthService {

    LoginResponseDTO authenticate(LoginRequestDTO loginDTO);
    void logout(String token);
    LoginResponseDTO register(UserRequestDTO userDTO);
}