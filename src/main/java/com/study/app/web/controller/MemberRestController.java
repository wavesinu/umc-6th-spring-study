package com.study.app.web.controller;

import com.study.app.converter.MemberConverter;
import com.study.app.domain.Member;
import com.study.app.service.member.MemberCommandService;
import com.study.app.web.dto.MemberRequest;
import com.study.app.web.dto.MemberResponse;
import com.study.global.apiPayLoad.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@Validated
public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponse.JoinResultDTO> join(
            @RequestBody @Valid MemberRequest.JoinDTO request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
