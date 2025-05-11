package umc.study.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.User;
import umc.study.repository.UserRepository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService{

    private final UserRepository userRepository;

    @Override
    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findUserById(long id) {
        List<User> filteredUser = userRepository.dynamicQueryWithBooleanBuilder(id);

        filteredUser.forEach(User -> System.out.println("User: " + User));

        return filteredUser;
    }
}