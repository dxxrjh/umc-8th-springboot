package umc.study.service.UserMissionService;

import org.springframework.data.domain.Page;
import umc.study.domain.mapping.UserMission;

import java.util.List;
import java.util.Optional;

public interface UserMissionQueryService {

    Page<UserMission> getUserMissionList(long userId, String status, Integer page);
}