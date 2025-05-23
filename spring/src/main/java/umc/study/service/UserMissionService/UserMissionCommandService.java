package umc.study.service.UserMissionService;

import umc.study.domain.mapping.UserMission;
import umc.study.web.dto.UserMissionResponseDTO;

public interface UserMissionCommandService {
    UserMissionResponseDTO.UserMissionChallengeResultDTO addMissionToUser(Long userId, Long missionId);
}
