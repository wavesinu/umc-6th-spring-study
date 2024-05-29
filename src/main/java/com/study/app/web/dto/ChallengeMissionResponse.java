package com.study.app.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ChallengeMissionResponse {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddChallengingMissionResultDTO{
        private Long challengeMissionId;
        private LocalDateTime createdAt;
    }
}
