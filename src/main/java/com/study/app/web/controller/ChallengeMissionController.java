package com.study.app.web.controller;

import com.study.app.converter.ChallengeMissionConverter;
import com.study.app.domain.mapping.ChallengeMission;
import com.study.app.service.challengeMission.ChallengeMissionCommandService;
import com.study.app.web.dto.ChallengeMissionRequest;
import com.study.app.web.dto.ChallengeMissionResponse;
import com.study.global.apiPayLoad.ApiResponse;
import com.study.global.validation.annotation.ExistChallengeMission;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions/challenge")
@RequiredArgsConstructor
@Validated
public class ChallengeMissionController {
    private final ChallengeMissionCommandService challengeMissionCommandService;

    @PutMapping("")
    public ApiResponse<ChallengeMissionResponse.AddChallengingMissionResultDTO> addChallengingMission(
            @RequestBody @ExistChallengeMission @Valid ChallengeMissionRequest.AddChallengingMissionDTO request
        ){
        ChallengeMission challengeMission = challengeMissionCommandService.addChallengingMission(request);
        return ApiResponse.onSuccess(ChallengeMissionConverter.toAddChallengingMissionResultDTO(challengeMission));
    }
}
