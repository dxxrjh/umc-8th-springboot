package umc.study.converter;

import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.domain.User;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class ReviewConverter {

    static final Long userId = 1L;

    public static Review toReview(ReviewRequestDTO.ReviewWritingDTO request, User user, Restaurant restaurant) {
        return Review.builder()
                .user(user)
                .restaurant(restaurant)
                .content(request.getContent())
                .rate(request.getRate())
                .build();
    }

    public static ReviewResponseDTO.ReviewWritingResultDTO toReviewResponse(Review review) {
        return ReviewResponseDTO.ReviewWritingResultDTO.builder()
                .userId(review.getUser().getId())
                .content(review.getContent())
                .rate(review.getRate())
                .restaurantId(review.getRestaurant().getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static ReviewResponseDTO.RestaurantReviewDTO toRestaurantReviewDTO(Review review) {
        return ReviewResponseDTO.RestaurantReviewDTO.builder()
                .userId(review.getUser().getId())
                .content(review.getContent())
                .rate(review.getRate())
                .createdAt(LocalDateTime.now())
                .build();
    }

}