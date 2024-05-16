package com.study.app.web.controller;

import com.study.app.converter.MissionConverter;
import com.study.app.domain.Mission;
import com.study.app.service.mission.MissionCommandService;
import com.study.app.web.dto.MissionRequest;
import com.study.app.web.dto.MissionResponse;
import com.study.global.apiPayLoad.ApiResponse;
import com.study.global.validation.annotation.ExistRestaurant;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
@Validated
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("")
    public ApiResponse<MissionResponse.addMissionResultDTO> addMission(
            @ExistRestaurant @RequestParam(value = "restaurantId", required = true) Long restaurantId,
            @RequestBody @Valid MissionRequest.addMissionDTO request
        ){
        Mission mission = missionCommandService.addMission(restaurantId, request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResultDTO(mission));
    }

}
