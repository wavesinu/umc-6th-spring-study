package com.study.app.service.store;

import com.study.app.domain.Store;
import com.study.app.domain.Review;
import com.study.app.repository.StoreRepository;
import com.study.app.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public boolean existById(Long id) {
        return storeRepository.existsById(id);
    }

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store = findStore(storeId).get();
        return reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
    }
}
