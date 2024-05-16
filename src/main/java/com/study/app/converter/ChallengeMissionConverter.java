package com.study.app.converter;

import com.study.app.domain.mapping.ChallengeMission;
import com.study.app.web.dto.ChallengeMissionResponse.AddChallengingMissionResultDTO;

public class ChallengeMissionConverter {
    public static AddChallengingMissionResultDTO toAddChallengingMissionResultDTO(ChallengeMission challengeMission){
        return AddChallengingMissionResultDTO.builder()
                .challengeMissionId(challengeMission.getId())
                .createdAt(challengeMission.getCreatedAt())
                .build();
    }

    public static ChallengeMission toChallengeMission(){
        return ChallengeMission.builder().build();
    }
}
