package ma.youcode.surveyit.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import ma.youcode.surveyit.annotation.interfaces.Unique;
import ma.youcode.surveyit.constant.RoleName;
import ma.youcode.surveyit.entity.User;
import ma.youcode.surveyit.util.groups.OnEditRole;
import org.starter.utilities.validation.annotations.ValidEnum;
import org.starter.utilities.validation.groups.OnCreate;

public record UserRequestDTO(
        @NotBlank(groups = {OnCreate.class}) String name,
        @NotBlank(groups = {OnCreate.class}) @Unique(entity = User.class, field = "email") String email,
        @NotBlank(groups = {OnCreate.class})
        @NotNull(groups = {OnCreate.class})
        String password,
        @NotNull(groups = {OnCreate.class,OnEditRole.class}) RoleName role
        ) {
}
