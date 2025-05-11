package umc.study.service.ReviewService;

import umc.study.domain.Restaurant;
import umc.study.domain.User;
import umc.study.dto.ReviewDTO;
import umc.study.repository.RestaurantRepository.RestaurantRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.UserRepository.UserRepository; // UserRepository import 추가
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;

import java.util.List;

@Service
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;  // UserRepository 주입
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public ReviewQueryServiceImpl(ReviewRepository reviewRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Review createReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setContent(reviewDTO.getContent());
        review.setRate(reviewDTO.getRate());

        User user = userRepository.findById(reviewDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        review.setUser(user);  // User 객체를 Review에 설정

        Restaurant restaurant = restaurantRepository.findById(reviewDTO.getRestaurantId())  // restaurantId로 Restaurant 객체 찾기
                .orElseThrow(() -> new IllegalArgumentException("레스토랑을 찾을 수 없습니다."));
        review.setRestaurant(restaurant);  // Restaurant 객체를 Review에 설정

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsByShop(Long restaurantId) {
        return reviewRepository.findReviewsByRestaurantId(restaurantId);
    }
}
