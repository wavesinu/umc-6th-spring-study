package com.study.global.validation.validator;

import com.study.app.service.storeCategory.StoreCategoryQueryService;
import com.study.global.apiPayLoad.code.status.ErrorStatus;
import com.study.global.validation.annotation.ExistStoreCategories;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantCategoriesExistValidator implements ConstraintValidator<ExistStoreCategories, Long> {
    private final StoreCategoryQueryService storeCategoryQueryService;

    @Override
    public void initialize(ExistStoreCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = storeCategoryQueryService.existById(value);

        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
