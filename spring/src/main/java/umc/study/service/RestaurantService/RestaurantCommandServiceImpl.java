package umc.study.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.CategoryHandler;
import umc.study.apiPayload.exception.handler.LocationHandler;
import umc.study.converter.RestaurantConverter;
import umc.study.domain.Category;
import umc.study.domain.Location;
import umc.study.domain.Restaurant;
import umc.study.repository.CategoryRepository;
import umc.study.repository.LocationRepository;
import umc.study.repository.RestaurantRepository.RestaurantRepository;
import umc.study.service.RestaurantService.RestaurantCommandService;
import umc.study.web.dto.RestaurantRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;
    private final CategoryRepository categoryRepository;
    private final LocationRepository locationRepository;

    @Override
    @Transactional
    public Restaurant createRestaurant(RestaurantRequestDTO.RestaurantEnrollDTO request) {

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new CategoryHandler(ErrorStatus.CATEGORY_NOT_FOUND));

        Location location = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new LocationHandler(ErrorStatus.LOCATION_NOT_FOUND));

        Restaurant restaurant = RestaurantConverter.toRestaurant(request, category, location);
        return restaurantRepository.save(restaurant);
    }
}
