package com.study.app.service.member;

import com.study.app.domain.Member;
import com.study.app.web.dto.MemberRequest;

public interface MemberCommandService {
    public Member joinMember(MemberRequest.JoinDTO request);
}
