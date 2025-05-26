package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.*;
import umc.study.web.controller.RestaurantController;
import umc.study.web.dto.RestaurantRequestDTO;
import umc.study.web.dto.RestaurantResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static RestaurantResponseDTO.RestaurantReviewListDTO restaurantReviewListDTO(Page<Review> reviewList){

        List<RestaurantResponseDTO.RestaurantReviewDTO> restaurantReviewDTOList = reviewList.stream()
                .map(RestaurantConverter::toRestaurantReviewDTO).collect(Collectors.toList());

        return RestaurantResponseDTO.RestaurantReviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(restaurantReviewDTOList.size())
                .reviewList(restaurantReviewDTOList)
                .build();
    }

    public static RestaurantResponseDTO.RestaurantReviewDTO toRestaurantReviewDTO(Review review) {
        return RestaurantResponseDTO.RestaurantReviewDTO.builder()
                .userId(review.getUser().getId())
                .content(review.getContent())
                .rate(review.getRate())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static RestaurantResponseDTO.RestaurantMissionListDTO restaurantMissionListDTO(Page<Mission> missionList){

        List<RestaurantResponseDTO.RestaurantMissionDTO> restaurantMissionDTOList = missionList.stream()
                .map(RestaurantConverter::toRestaurantMissionDTO).collect(Collectors.toList());

        return RestaurantResponseDTO.RestaurantMissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(restaurantMissionDTOList.size())
                .missionList(restaurantMissionDTOList)
                .build();
    }

    public static RestaurantResponseDTO.RestaurantMissionDTO toRestaurantMissionDTO(Mission mission) {
        return RestaurantResponseDTO.RestaurantMissionDTO.builder()
                .restaurantId(mission.getRestaurant().getId())
                .description(mission.getDescription())
                .point(mission.getPoint())
                .dueDate(mission.getDueDate())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}