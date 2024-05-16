package com.study.app.service.storeCategory;

import com.study.app.repository.StoreCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCategoryQueryServiceImpl implements StoreCategoryQueryService {
    private final StoreCategoryRepository storeCategoryRepository;

    @Override
    public boolean existById(Long id) {
        return storeCategoryRepository.existsById(id);
    }
}
