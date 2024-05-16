package com.study.global.validation.validator;

import com.study.app.service.store.StoreQueryService;
import com.study.global.apiPayLoad.code.status.ErrorStatus;
import com.study.global.validation.annotation.ExistRestaurant;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantExistValidator implements ConstraintValidator<ExistRestaurant, Long> {
    private final StoreQueryService storeQueryService;

    @Override
    public void initialize(ExistRestaurant constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = storeQueryService.existById(value);

        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
