package umc.study.service.UserService;

import umc.study.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {

    Optional<User> findUser(Long id);
    List<User> findUserById(long id);
}