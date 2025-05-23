package umc.study.web.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.UserMissionService.UserMissionCommandService;
import umc.study.validation.annotation.DuplicateMission;
import umc.study.web.dto.UserMissionResponseDTO;

@RestController
public class UserMissionController {

    private final UserMissionCommandService userMissionService;

    public UserMissionController(UserMissionCommandService userMissionService) {
        this.userMissionService = userMissionService;
    }

    @PostMapping("/{missionId}")
    public ApiResponse<UserMissionResponseDTO.UserMissionChallengeResultDTO> addMissionToUser(@PathVariable @Valid Long missionId) {
        Long userId = 1L; // 하드코딩

        UserMissionResponseDTO.UserMissionChallengeResultDTO response = userMissionService.addMissionToUser(userId, missionId);
        return ApiResponse.onSuccess(response);
    }
}
