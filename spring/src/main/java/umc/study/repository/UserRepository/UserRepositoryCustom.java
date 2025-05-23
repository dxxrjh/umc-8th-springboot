package umc.study.repository.UserRepository;

import umc.study.domain.User;

import java.util.List;


public interface UserRepositoryCustom {
    List<User> dynamicQueryWithBooleanBuilder(long id);
}