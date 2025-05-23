package umc.study.service.UserMissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.UserMissionResponseDTO;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService {
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    @Transactional
    public UserMissionResponseDTO.UserMissionChallengeResultDTO addMissionToUser(Long userId, Long missionId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid userId"));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid missionId"));

        boolean isAlreadyDoing = userMissionRepository
                .existsByUserIdAndMissionIdAndStatus(userId, missionId, MissionStatus.DOING);

        if (isAlreadyDoing) {
            throw new MissionHandler(ErrorStatus.ALREADY_CHALLENGED_MISSION);
        }


        Restaurant restaurant = mission.getRestaurant();

        UserMission userMission = UserMission.builder()
                .user(user)
                .mission(mission)
                .status(MissionStatus.DOING)
                .build();

        userMissionRepository.save(userMission);

        return UserMissionResponseDTO.UserMissionChallengeResultDTO.builder()
                .userId(userId)
                .userMissionId(userMission.getId())
                .missionId(mission.getId())
                .restaurantId(restaurant.getId())
                .restaurantName(restaurant.getName())
                .description(mission.getDescription())
                .point(mission.getPoint())
                .dueDate(mission.getDueDate())
                .status(userMission.getStatus().toString())
                .createdAt(userMission.getCreatedAt())
                .build();
    }

}

