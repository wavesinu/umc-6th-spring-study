package com.study.app.service.store;

import com.study.app.domain.Store;
import com.study.app.web.dto.StoreRequest;

public interface StoreCommandService {
    Store addStore(StoreRequest.addStoreDTO request);
}
