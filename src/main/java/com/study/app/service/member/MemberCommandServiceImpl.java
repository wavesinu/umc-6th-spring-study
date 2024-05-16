package com.study.app.service.member;

import com.study.app.converter.MemberConverter;
import com.study.app.converter.MemberPreferConverter;
import com.study.app.domain.FoodCategory;
import com.study.app.domain.Member;
import com.study.app.domain.mapping.MemberFoodCategory;
import com.study.app.repository.FoodCategoryRepository;
import com.study.app.repository.MemberRepository;
import com.study.app.web.dto.MemberRequest;
import com.study.global.apiPayLoad.code.status.ErrorStatus;
import com.study.global.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequest.JoinDTO request) {
        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategories = request.getPreferCategory().stream()
                .map(category -> foodCategoryRepository
                                .findById(category)
                                .orElseThrow(() -> new TempHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)))
                .toList();
        List<MemberFoodCategory> memberFoodCategories = MemberPreferConverter.toMemberFoodCategory(foodCategories);
        memberFoodCategories.forEach(memberPrefer -> memberPrefer.setMember(newMember));
        return memberRepository.save(newMember);
    }
}
