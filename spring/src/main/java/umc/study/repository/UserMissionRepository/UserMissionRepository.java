package umc.study.repository.UserMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Long>, UserMissionRepositoryCustom {
    boolean existsByUserIdAndMissionIdAndStatus(Long userId, Long missionId, MissionStatus status);
}