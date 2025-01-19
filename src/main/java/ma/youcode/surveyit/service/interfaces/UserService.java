package ma.youcode.surveyit.service.interfaces;

import ma.youcode.surveyit.dto.request.user.UserRequestDTO;
import ma.youcode.surveyit.entity.User;

public interface UserService {

    void create(UserRequestDTO dto);
    User findByEmail(String email);
    User findById(Long id);
//    void editRole(Long userId , RoleName role);

}
