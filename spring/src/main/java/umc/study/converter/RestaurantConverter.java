package umc.study.converter;

import umc.study.domain.Category;
import umc.study.domain.Location;
import umc.study.domain.Restaurant;
import umc.study.web.dto.RestaurantRequestDTO;
import umc.study.web.dto.RestaurantResponseDTO;

import java.time.LocalDateTime;

public class RestaurantConverter {

    public static Restaurant toRestaurant(RestaurantRequestDTO.RestaurantEnrollDTO dto, Category category, Location location) {
        return Restaurant.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .category(category)
                .location(location)
                .build();
    }

    public static RestaurantResponseDTO.RestaurantEnrollResultDTO toRestaurantResponse(Restaurant restaurant) {
        return RestaurantResponseDTO.RestaurantEnrollResultDTO.builder()
                .restaurantId(restaurant.getId())
                .name(restaurant.getName())
                .locationId(restaurant.getLocation().getId())
                .categoryId(restaurant.getCategory().getId())
                .address(restaurant.getAddress())
                .createdAt(LocalDateTime.now())
                .build();
    }
}