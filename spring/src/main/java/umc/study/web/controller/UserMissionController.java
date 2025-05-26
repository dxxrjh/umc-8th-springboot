package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.RestaurantConverter;
import umc.study.converter.UserMissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.mapping.UserMission;
import umc.study.service.UserMissionService.UserMissionCommandService;
import umc.study.service.UserMissionService.UserMissionQueryService;
import umc.study.validation.annotation.DuplicateMission;
import umc.study.validation.annotation.ExistRestaurant;
import umc.study.web.dto.RestaurantResponseDTO;
import umc.study.web.dto.UserMissionResponseDTO;

@RestController
@RequestMapping("/missions")
public class UserMissionController {

    private final UserMissionCommandService userMissionCommandService;
    private final UserMissionQueryService userMissionQueryService;

    public UserMissionController(UserMissionCommandService userMissionService, UserMissionQueryService userMissionQueryService) {
        this.userMissionCommandService = userMissionService;
        this.userMissionQueryService = userMissionQueryService;
    }

    @PostMapping("/{missionId}")
    @Operation(summary = "미션 도전 API",description = "특정 미션에 도전하는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "missionId", description = "미션 아이디, path variable 입니다!")
    })
    public ApiResponse<UserMissionResponseDTO.UserMissionChallengeResultDTO> addMissionToUser(@PathVariable @Valid Long missionId) {
        Long userId = 1L; // 하드코딩

        UserMissionResponseDTO.UserMissionChallengeResultDTO response = userMissionCommandService.addMissionToUser(userId, missionId);
        return ApiResponse.onSuccess(response);
    }

    @GetMapping("")
    @Operation(summary = "사용자 미션 목록 조회 API",description = "사용자 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "status", description = "미션 상태(DOING or DONE), path variable 입니다!")
    })
    public ApiResponse<UserMissionResponseDTO.UserMissionListDTO> getUserMissionList(@RequestParam(name = "status") String status, @RequestParam(name = "page") Integer page){

        Page<UserMission> missionList = userMissionQueryService.getUserMissionList(1L, status, page);
        return ApiResponse.onSuccess(UserMissionConverter.userMissionListDTO(missionList));
    }
}
