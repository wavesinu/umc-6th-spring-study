package com.study.app.service.store;

import com.study.app.domain.Store;
import com.study.app.domain.Review;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StoreQueryService {
    boolean existById(Long id);
    Optional<Store> findStore(Long id);
    Page<Review> getReviewList(Long storeId, Integer page);
}
