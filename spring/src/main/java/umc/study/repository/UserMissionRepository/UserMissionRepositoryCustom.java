package umc.study.repository.UserMissionRepository;

import umc.study.domain.mapping.userMission;

import java.util.List;


public interface UserMissionRepositoryCustom {
    List<userMission> dynamicQueryWithBooleanBuilder(long id, String status);
}