package com.study.global.validation.validator;

import com.study.app.service.challengeMission.ChallengeMissionQueryService;
import com.study.app.web.dto.ChallengeMissionRequest;
import com.study.global.apiPayLoad.code.status.ErrorStatus;
import com.study.global.validation.annotation.ExistChallengeMission;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChallengeMissionExistValidator implements ConstraintValidator<ExistChallengeMission, ChallengeMissionRequest.AddChallengingMissionDTO> {
    private final ChallengeMissionQueryService challengeMissionQueryService;

    @Override
    public void initialize(ExistChallengeMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ChallengeMissionRequest.AddChallengingMissionDTO value, ConstraintValidatorContext context) {
        boolean isValid = !challengeMissionQueryService.existsByMemberIdAndMissionId(value.getMemberId(), value.getMissionId());

        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.CHALLENGE_MISSION_EXISTS.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
