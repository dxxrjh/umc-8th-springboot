package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.repository.RestaurantRepository.RestaurantRepository;

import umc.study.validation.annotation.ExistRestaurant;

@Component
@RequiredArgsConstructor
public class RestaurantExistValidator implements ConstraintValidator<ExistRestaurant, Long> {

    private final RestaurantRepository restaurantRepository;

    @Override
    public boolean isValid(Long restaurantId, ConstraintValidatorContext context) {
        if (restaurantId == null) {
            return false;
        }
        return restaurantRepository.existsById(restaurantId);
    }
}