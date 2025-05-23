package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.RestaurantConverter;
import umc.study.domain.Category;
import umc.study.domain.Location;
import umc.study.domain.Restaurant;
import umc.study.service.RestaurantService.RestaurantCommandService;
import umc.study.service.RestaurantService.RestaurantCommandService;
import umc.study.web.dto.RestaurantRequestDTO;
import umc.study.web.dto.RestaurantResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantCommandService restaurantService;

    @PostMapping
    public ApiResponse<RestaurantResponseDTO.RestaurantEnrollResultDTO> createRestaurant(
            @RequestBody @Valid RestaurantRequestDTO.RestaurantEnrollDTO request) {

        Restaurant restaurant = restaurantService.createRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toRestaurantResponse(restaurant));
    }
}
