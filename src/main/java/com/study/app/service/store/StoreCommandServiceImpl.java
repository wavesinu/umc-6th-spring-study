package com.study.app.service.store;

import com.study.app.converter.StoreConverter;
import com.study.app.domain.Store;
import com.study.app.domain.StoreCategory;
import com.study.app.repository.StoreCategoryRepository;
import com.study.app.repository.StoreRepository;
import com.study.app.web.dto.StoreRequest;
import com.study.global.apiPayLoad.code.status.ErrorStatus;
import com.study.global.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;
    private final StoreCategoryRepository storeCategoryRepository;

    @Transactional
    @Override
    public Store addStore(StoreRequest.addStoreDTO request) {
        Store newStore = StoreConverter.toStore(request);
        StoreCategory storeCategory = storeCategoryRepository.findById(request.getStoreCategoryId())
                .orElseThrow(() -> new TempHandler(ErrorStatus.RESTAURANT_CATEGORY_NOT_FOUND));
        newStore.setStoreCategory(storeCategory);
        return storeRepository.save(newStore);
    }
}
