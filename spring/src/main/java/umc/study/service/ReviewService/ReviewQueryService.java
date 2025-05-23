package umc.study.service.ReviewService;

import jakarta.validation.Valid;
import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;

import java.util.List;

public interface ReviewQueryService {

    Review createReview(ReviewRequestDTO.@Valid ReviewWritingDTO request, Long restaurantId);
    List<Review> getReviewsByRestaurant(Long restaurantId);
}
