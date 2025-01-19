package ma.youcode.surveyit.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.youcode.surveyit.dto.request.login.LoginRequestDTO;
import ma.youcode.surveyit.dto.request.user.UserRequestDTO;
import ma.youcode.surveyit.service.interfaces.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.starter.utilities.dtos.SimpleSuccessDTO;
import org.starter.utilities.markers.validation.OnCreate;

import static org.starter.utilities.response.Response.simpleSuccess;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<SimpleSuccessDTO> handleLogin(@RequestBody @Valid LoginRequestDTO loginDTO) {
        return simpleSuccess(200 , "Logged in successfully.",authService.authenticate(loginDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<SimpleSuccessDTO> handleRegister(@RequestBody @Validated(OnCreate.class) UserRequestDTO userDTO) {
        return simpleSuccess(200 , "Registered successfully.",authService.register(userDTO));
    }



}
