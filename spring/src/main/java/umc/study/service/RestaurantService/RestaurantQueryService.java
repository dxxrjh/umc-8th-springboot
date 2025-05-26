package umc.study.service.RestaurantService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;

import java.util.List;
import java.util.Optional;

public interface RestaurantQueryService {

    Page<Review> getRestaurantReviewList(Long restaurantId, Integer page);
    Page<Mission> getRestaurantMissionList(Long restaurantId, Integer page);

}