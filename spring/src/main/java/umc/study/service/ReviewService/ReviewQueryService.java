package umc.study.service.ReviewService;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;

import java.util.List;

public interface ReviewQueryService {

    Review createReview(ReviewRequestDTO.@Valid ReviewWritingDTO request, Long restaurantId);
    Page<Review> getUserReviewList(Long userId, Integer page);

}
