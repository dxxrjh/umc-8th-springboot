package umc.study.converter;


import org.springframework.data.domain.Page;
import umc.study.domain.mapping.UserMission;
import umc.study.web.dto.UserMissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class UserMissionConverter {

    static final Long userId = 1L;

    public static UserMissionResponseDTO.UserMissionListDTO userMissionListDTO(Page<UserMission> userMissionList){

        List<UserMissionResponseDTO.UserMissionDTO> userMissionDTOList = userMissionList.stream()
                .map(UserMissionConverter::toUserMissionDTO).collect(Collectors.toList());

        return UserMissionResponseDTO.UserMissionListDTO.builder()
                .isLast(userMissionList.isLast())
                .isFirst(userMissionList.isFirst())
                .totalPage(userMissionList.getTotalPages())
                .totalElements(userMissionList.getTotalElements())
                .listSize(userMissionDTOList.size())
                .userMissionList(userMissionDTOList)
                .build();
    }

    public static UserMissionResponseDTO.UserMissionDTO toUserMissionDTO (UserMission userMission) {
        return UserMissionResponseDTO.UserMissionDTO.builder()
                .userId(userMission.getUser().getId())
                .userMissionId(userMission.getId())
                .missionId(userMission.getMission().getId())
                .restaurantId(userMission.getMission().getRestaurant().getId())
                .restaurantName(userMission.getMission().getRestaurant().getName())
                .description(userMission.getMission().getDescription())
                .point(userMission.getMission().getPoint())
                .dueDate(userMission.getMission().getDueDate())
                .status(String.valueOf(userMission.getStatus()))
                .build();
    }

}