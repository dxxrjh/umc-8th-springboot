package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.LocationExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LocationExistValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistLocation {
    String message() default "존재하지 않는 위치 ID 입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}