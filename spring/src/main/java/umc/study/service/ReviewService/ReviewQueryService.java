package umc.study.service.ReviewService;

import umc.study.domain.Review;
import umc.study.dto.ReviewDTO;

import java.util.List;

public interface ReviewQueryService {
    Review createReview(ReviewDTO reviewDTO);
    List<Review> getReviewsByShop(Long restaurantId);
}
