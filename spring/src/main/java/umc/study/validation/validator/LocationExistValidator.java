package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.repository.LocationRepository;
import umc.study.validation.annotation.ExistLocation;

@Component
@RequiredArgsConstructor
public class LocationExistValidator implements ConstraintValidator<ExistLocation, Long> {

    private final LocationRepository locationRepository;

    @Override
    public boolean isValid(Long locationId, ConstraintValidatorContext context) {
        if (locationId == null) {
            return false;
        }
        return locationRepository.existsById(locationId);
    }
}