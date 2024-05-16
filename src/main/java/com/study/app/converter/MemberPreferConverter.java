package com.study.app.converter;

import com.study.app.domain.FoodCategory;
import com.study.app.domain.mapping.MemberFoodCategory;

import java.util.List;

public class MemberPreferConverter {
    public static List<MemberFoodCategory> toMemberFoodCategory(List<FoodCategory> foodCategories){
        return foodCategories.stream().map(
                foodCategory -> MemberFoodCategory.builder()
                        .foodCategory(foodCategory)
                        .build())
                .toList();
    }
}
