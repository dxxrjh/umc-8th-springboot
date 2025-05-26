package umc.study.service.ReviewService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.LocationHandler;
import umc.study.apiPayload.exception.handler.PageHandler;
import umc.study.apiPayload.exception.handler.RestaurantHandler;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.domain.User;
import umc.study.repository.RestaurantRepository.RestaurantRepository;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.UserRepository.UserRepository; // UserRepository import 추가
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;
import umc.study.converter.ReviewConverter;

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
    public Review createReview(ReviewRequestDTO.ReviewWritingDTO request, Long restaurantId) {

        User user = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        Review review = ReviewConverter.toReview(request, user, restaurant);
        return reviewRepository.save(review);
    }

    @Override
    public Page<Review> getUserReviewList(Long userId, Integer page) {
        System.out.println(">>> 들어온 page: " + page); // ✅ 로그
        // 페이지 유효성 검사
        if (page == null || page < 1) {
            System.out.println(">>> PAGE ERROR 발생"); // ✅ 로그
            throw new PageHandler(ErrorStatus.PAGE_NOT_VALID);
        }

        // 검증된 페이지 값만 PageRequest 생성
        int zeroBasedPage = page - 1; // 0 기반으로 변환
        PageRequest pageRequest = PageRequest.of(zeroBasedPage, 10);

        User user = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return reviewRepository.findAllByUser(user, pageRequest);
    }



}
