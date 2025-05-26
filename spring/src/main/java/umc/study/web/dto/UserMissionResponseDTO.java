package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UserMissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserMissionChallengeResultDTO {
        private Long userId;
        private Long userMissionId;
        private Long missionId;
        private Long restaurantId;
        private String restaurantName;
        private String description;
        private Integer point;
        private LocalDate dueDate;
        private String status;
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserMissionListDTO {
        List<UserMissionResponseDTO.UserMissionDTO> userMissionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserMissionDTO {

        Long userId;
        Long userMissionId;
        Long missionId;
        Long restaurantId;
        String restaurantName;
        String description;
        Integer point;
        LocalDate dueDate;
        String status;
    }

}
