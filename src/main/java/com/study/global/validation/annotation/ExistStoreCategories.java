package com.study.global.validation.annotation;

import com.study.global.validation.validator.RestaurantCategoriesExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.Valid;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RestaurantCategoriesExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Valid
public @interface ExistStoreCategories {
    String message() default "해당하는 식당 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
