package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class RestaurantRequestDTO {

    @Getter
    public static class RestaurantEnrollDTO {
        @NotNull
        private String name;
        @NotNull
        private String address;
        @NotNull
        private Long categoryId;
        @NotNull
        @NotNull
        private Long locationId;
    }
}
