package com.study.app.converter;

import com.study.app.domain.Mission;
import com.study.app.web.dto.MissionRequest;
import com.study.app.web.dto.MissionResponse;

import java.time.LocalDate;

public class MissionConverter {
    public static MissionResponse.addMissionResultDTO toAddMissionResultDTO(Mission mission){
        return MissionResponse.addMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(MissionRequest.addMissionDTO request){
        return Mission.builder()
                .point(request.getPoint())
                .foodPrice(request.getFoodPrice())
                .deadline(request.getDeadLine())
                .deadline(LocalDate.now())
                .build();
    }
}
