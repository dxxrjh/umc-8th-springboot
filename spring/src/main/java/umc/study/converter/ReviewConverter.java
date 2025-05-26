package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.domain.User;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;
import umc.study.web.dto.RestaurantResponseDTO;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

    public static ReviewResponseDTO.UserReviewListDTO userReviewListDTO(Page<Review> reviewList){

        List<ReviewResponseDTO.UserReviewDTO> userReviewDTOList = reviewList.stream()
                .map(ReviewConverter::toUserReviewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.UserReviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(userReviewDTOList.size())
                .reviewList(userReviewDTOList)
                .build();
    }

    public static ReviewResponseDTO.UserReviewDTO toUserReviewDTO (Review review) {
        return ReviewResponseDTO.UserReviewDTO.builder()
                .userId(review.getUser().getId())
                .reviewId(review.getId())
                .restaurantId(review.getRestaurant().getId())
                .content(review.getContent())
                .rate(review.getRate())
                .createdAt(review.getCreatedAt())
                .build();
    }

}