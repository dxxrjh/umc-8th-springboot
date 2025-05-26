package umc.study.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.PageHandler;
import umc.study.apiPayload.exception.handler.RestaurantHandler;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.RestaurantRepository.RestaurantRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantQueryServiceImpl implements RestaurantQueryService{

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Page<Review> getRestaurantReviewList(Long restaurantId, Integer page) {
        System.out.println(">>> 들어온 page: " + page); // ✅ 로그
        // 페이지 유효성 검사
        if (page == null || page < 1) {
            System.out.println(">>> PAGE ERROR 발생"); // ✅ 로그
            throw new PageHandler(ErrorStatus.PAGE_NOT_VALID);
        }

        // 식당 존재 여부 검사
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        // 검증된 페이지 값만 PageRequest 생성
        int zeroBasedPage = page - 1; // 0 기반으로 변환
        PageRequest pageRequest = PageRequest.of(zeroBasedPage, 10);

        return reviewRepository.findAllByRestaurant(restaurant, pageRequest);
    }

    @Override
    public Page<Mission> getRestaurantMissionList(Long restaurantId, Integer page) {
        System.out.println(">>> 들어온 page: " + page); // ✅ 로그
        // 페이지 유효성 검사
        if (page == null || page < 1) {
            System.out.println(">>> PAGE ERROR 발생"); // ✅ 로그
            throw new PageHandler(ErrorStatus.PAGE_NOT_VALID);
        }

        // 식당 존재 여부 검사
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        // 검증된 페이지 값만 PageRequest 생성
        int zeroBasedPage = page - 1; // 0 기반으로 변환
        PageRequest pageRequest = PageRequest.of(zeroBasedPage, 10);

        return missionRepository.findAllByRestaurant(restaurant, pageRequest);
    }




}