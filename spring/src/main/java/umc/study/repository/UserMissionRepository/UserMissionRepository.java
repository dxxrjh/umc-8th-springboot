package umc.study.repository.UserMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.userMission;

public interface UserMissionRepository extends JpaRepository<userMission, Long>, UserMissionRepositoryCustom {
}