package com.study.global.validation.validator;

import com.study.app.service.foodCategory.FoodCategoryQueryService;
import com.study.global.apiPayLoad.code.status.ErrorStatus;
import com.study.global.validation.annotation.ExistFoodCategories;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FoodCategoriesExistValidator implements ConstraintValidator<ExistFoodCategories, List<Long>> {
    private final FoodCategoryQueryService foodCategoryQueryService;
    @Override
    public void initialize(ExistFoodCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = foodCategoryQueryService.existById(values);

        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
