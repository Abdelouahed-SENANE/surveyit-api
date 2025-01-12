package ma.youcode.surveyit.service.implementations;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import ma.youcode.surveyit.constant.RoleName;
import ma.youcode.surveyit.dto.request.user.UserRequestDTO;
import ma.youcode.surveyit.entity.Admin;
import ma.youcode.surveyit.entity.Owner;
import ma.youcode.surveyit.entity.User;
import ma.youcode.surveyit.exception.custom.EntityNotFoundException;
import ma.youcode.surveyit.repository.UserRepository;
import ma.youcode.surveyit.service.interfaces.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    @Override
    public void create(UserRequestDTO dto) {

        if (isTaken(dto.email())) {
            throw new EntityExistsException("Email is already taken.");
        }

        if (dto.role().equals(RoleName.ROLE_ADMIN) ) {

            Admin user = (Admin) Admin.builder()
                    .name(dto.name())
                    .email(dto.email())
                    .password(encoder.encode(dto.password()))
                    .role(RoleName.ROLE_ADMIN)
                    .build();
            repository.save(user);
        }


        if (dto.role().equals(RoleName.ROLE_OWNER) ) {

            Owner user = (Owner) Owner.builder()
                    .name(dto.name())
                    .email(dto.email())
                    .password(encoder.encode(dto.password()))
                    .role(RoleName.ROLE_OWNER)
                    .build();
            repository.save(user);
        }


    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("User not found."));
    }

    private boolean isTaken(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found."));
    }

//    @Override
//    public void editRole(Long userId, RoleName role) {
//        User user = findById(userId);
//        switch (role) {
//            case ROLE_ADMIN :
//                Admin admin = (Admin) Admin.builder()
//                                .name(user.getName())
//                                .email(user.getEmail())
//                                .password(user.getPassword())
//                                .build();
//                repository.save(admin);
//                break;
//            case ROLE_OWNER:
//                Owner owner = (Owner) Owner.builder()
//                        .name(user.getName())
//                        .email(user.getEmail())
//                        .password(user.getPassword())
//                        .build();
//                repository.save(owner);
//                break;
//            default:
//                throw new IllegalArgumentException("Unknown role.");
//        }
//        repository.delete(user);
//    }
}
