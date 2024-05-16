package com.study.app.service.challengeMission;

import com.study.app.converter.ChallengeMissionConverter;
import com.study.app.domain.Member;
import com.study.app.domain.Mission;
import com.study.app.domain.mapping.ChallengeMission;
import com.study.app.repository.MemberRepository;
import com.study.app.repository.MissionRepository;
import com.study.app.web.dto.ChallengeMissionRequest;
import com.study.global.apiPayLoad.code.status.ErrorStatus;
import com.study.global.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChallengeMissionCommandServiceImpl implements ChallengeMissionCommandService {
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Transactional
    @Override
    public ChallengeMission addChallengingMission(ChallengeMissionRequest.AddChallengingMissionDTO request) {
        ChallengeMission newChallengeMission = ChallengeMissionConverter.toChallengeMission();
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        newChallengeMission.setMember(member);
        newChallengeMission.setMission(mission);
        return newChallengeMission;
    }
}
