package com.study.app.web.dto;

import com.study.global.validation.annotation.ExistStoreCategories;
import lombok.Getter;

public class StoreRequest {

    @Getter
    public static class addStoreDTO {
        private String name;
        private String address;
        @ExistStoreCategories
        private Long StoreCategoryId;
    }
}
