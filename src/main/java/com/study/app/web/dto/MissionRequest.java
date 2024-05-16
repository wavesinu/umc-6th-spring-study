package com.study.app.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequest {
    @Getter
    public static class addMissionDTO{
        @NotNull
        private Integer point;
        @NotNull
        private Integer foodPrice;
        private LocalDate deadLine;
    }
}
