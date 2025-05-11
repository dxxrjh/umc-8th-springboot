package umc.study.repository.UserRepository;

import umc.study.domain.User;
import umc.study.domain.mapping.userMission;

import java.util.List;


public interface UserRepositoryCustom {
    List<User> dynamicQueryWithBooleanBuilder(long id);
}