package umc.study.service.UserMissionService;

import umc.study.domain.mapping.UserMission;

import java.util.List;
import java.util.Optional;

public interface UserMissionQueryService {

    Optional<UserMission> findUserMission(Long id);
    List<UserMission> findUserMissionsByIdAndStatus(long id, String status);
}