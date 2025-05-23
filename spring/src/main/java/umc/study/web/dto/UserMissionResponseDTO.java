package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

}
