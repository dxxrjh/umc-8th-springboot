package umc.study.controller;

import umc.study.dto.ReviewDTO;
import umc.study.service.ReviewService.ReviewQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umc.study.domain.Review;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    @Autowired
    public ReviewController(ReviewQueryService reviewQueryService) {
        this.reviewQueryService = reviewQueryService;
    }

    @PostMapping
    public Review createReview(@RequestBody ReviewDTO reviewDTO) {
        return reviewQueryService.createReview(reviewDTO);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<Review> getReviewsByShop(@PathVariable Long restaurantId) {
        return reviewQueryService.getReviewsByShop(restaurantId);
    }
}
