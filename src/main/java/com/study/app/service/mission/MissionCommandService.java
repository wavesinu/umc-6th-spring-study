package com.study.app.service.mission;

import com.study.app.domain.Mission;
import com.study.app.web.dto.MissionRequest;

public interface MissionCommandService {
    Mission addMission(Long restaurantId, MissionRequest.addMissionDTO request);
}
