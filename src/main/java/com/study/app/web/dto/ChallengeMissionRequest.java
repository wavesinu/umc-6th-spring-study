package com.study.app.web.dto;

import com.study.global.validation.annotation.ExistMember;
import com.study.global.validation.annotation.ExistMission;
import lombok.Getter;

public class ChallengeMissionRequest {
    @Getter
    public static class AddChallengingMissionDTO{
        @ExistMember
        private Long memberId;
        @ExistMission
        private Long missionId;
    }
}
