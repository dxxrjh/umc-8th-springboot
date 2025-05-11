package umc.study.service.UserMissionService;

import umc.study.domain.mapping.userMission;

import java.util.List;
import java.util.Optional;

public interface UserMissionQueryService {

    Optional<userMission> findUserMission(Long id);
    List<userMission> findUserMissionsByIdAndStatus(long id, String status);
}