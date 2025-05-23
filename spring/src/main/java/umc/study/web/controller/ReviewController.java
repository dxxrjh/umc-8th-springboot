package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.service.ReviewService.ReviewQueryService;
import org.springframework.web.bind.annotation.*;
import umc.study.domain.Review;
import umc.study.web.dto.ReviewResponseDTO;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    @PostMapping("/restaurant/{restaurantId}")
    public ApiResponse<ReviewResponseDTO.ReviewWritingResultDTO> createReview(
            @PathVariable Long restaurantId,
            @RequestBody @Valid ReviewRequestDTO.ReviewWritingDTO request) {

        Review review = reviewQueryService.createReview(request, restaurantId);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResponse(review));

    }

    @GetMapping("/restaurant/{restaurantId}")
    public ApiResponse<List<ReviewResponseDTO.RestaurantReviewDTO>> getReviewsByRestaurant(
            @PathVariable Long restaurantId) {

        List<Review> reviews = reviewQueryService.getReviewsByRestaurant(restaurantId);
        List<ReviewResponseDTO.RestaurantReviewDTO> responseDTOs = reviews.stream()
                .map(ReviewConverter::toRestaurantReviewDTO)
                .toList();

        return ApiResponse.onSuccess(responseDTOs);
    }
}
