package com.study.app.service.challengeMission;

import com.study.app.domain.mapping.ChallengeMission;
import com.study.app.web.dto.ChallengeMissionRequest;

public interface ChallengeMissionCommandService {
    ChallengeMission addChallengingMission(ChallengeMissionRequest.AddChallengingMissionDTO request);
}
