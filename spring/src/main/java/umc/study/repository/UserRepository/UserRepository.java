package umc.study.repository.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.User;
import umc.study.domain.mapping.userMission;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}