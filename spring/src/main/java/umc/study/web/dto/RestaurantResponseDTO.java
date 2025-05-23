package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class RestaurantResponseDTO {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class RestaurantEnrollResultDTO {
        private Long restaurantId;
        private String name;
        private Long locationId;
        private String address;
        private Long categoryId;
        private LocalDateTime createdAt;
    }
}

