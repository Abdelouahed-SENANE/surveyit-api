package ma.youcode.surveyit.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.youcode.surveyit.constant.RoleName;
import ma.youcode.surveyit.dto.request.user.UserRequestDTO;
import ma.youcode.surveyit.service.interfaces.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.starter.utilities.dtos.SimpleSuccessDTO;
import org.starter.utilities.validation.annotations.ValidEnum;

import static org.starter.utilities.response.Response.simpleSuccess;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("test")
    public String test() {
        return "test";
    }
}
