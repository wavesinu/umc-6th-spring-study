package com.study.app.service.mission;

import com.study.app.converter.MissionConverter;
import com.study.app.domain.Mission;
import com.study.app.domain.Store;
import com.study.app.repository.MissionRepository;
import com.study.app.repository.StoreRepository;
import com.study.app.web.dto.MissionRequest;
import com.study.global.apiPayLoad.code.status.ErrorStatus;
import com.study.global.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Transactional
    @Override
    public Mission addMission(Long restaurantId, MissionRequest.addMissionDTO request) {
        Mission newMission = MissionConverter.toMission(request);
        Store store = storeRepository.findById(restaurantId).orElseThrow(() -> new TempHandler(ErrorStatus.RESTAURANT_NOT_FOUND));
        newMission.setStore(store);
        return missionRepository.save(newMission);
    }
}
