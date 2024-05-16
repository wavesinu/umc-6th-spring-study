package com.study.app.converter;

import com.study.app.domain.Store;
import com.study.app.web.dto.StoreRequest;
import com.study.app.web.dto.StoreResponse;

import java.util.ArrayList;

public class StoreConverter {

    public static Store toStore(StoreRequest.addStoreDTO request){
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .reviews(new ArrayList<>())
                .build();
    }

    public static StoreResponse.addStoreResultDTO toAddStoreResultDTO(Store store){
        return StoreResponse.addStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }


}
