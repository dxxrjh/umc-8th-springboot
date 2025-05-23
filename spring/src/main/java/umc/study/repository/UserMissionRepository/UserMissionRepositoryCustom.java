package umc.study.repository.UserMissionRepository;

import umc.study.domain.mapping.UserMission;

import java.util.List;


public interface UserMissionRepositoryCustom {
    List<UserMission> dynamicQueryWithBooleanBuilder(long id, String status);
}