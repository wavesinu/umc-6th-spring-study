package com.study.app.service.review;

import com.study.app.converter.ReviewConverter;
import com.study.app.domain.Member;
import com.study.app.domain.Store;
import com.study.app.domain.Review;
import com.study.app.repository.MemberRepository;
import com.study.app.repository.StoreRepository;
import com.study.app.repository.ReviewRepository;
import com.study.app.web.dto.ReviewRequest;
import com.study.global.apiPayLoad.code.status.ErrorStatus;
import com.study.global.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Transactional
    @Override
    public Review addReview(Long memberId, Long restaurantId, ReviewRequest.AddReviewDTO request) {
        Review newReview = ReviewConverter.toReview(request);
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(restaurantId).orElseThrow(() -> new TempHandler(ErrorStatus.RESTAURANT_NOT_FOUND));
        newReview.setMember(member);
        newReview.setStore(store);
        return reviewRepository.save(newReview);
    }

    @Override
    public void check(Long memberId, Long restaurantId, ReviewRequest.AddReviewDTO request) {
        memberRepository.findById(memberId).orElseThrow(
                        () -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND))
                .getReviews().forEach(
                        r -> System.out.println("reviewId : " + r.getId() + ", restaurantId : " + r.getStore().getId()));
        storeRepository.findById(restaurantId).orElseThrow(
                        () -> new TempHandler(ErrorStatus.RESTAURANT_NOT_FOUND))
                .getReviews().forEach(
                        r -> System.out.println("reviewId : " + r.getId() + ", memberId : "  + r.getMember().getId()));
    }

    @Override
    public void check2() {
        memberRepository.findById(1L).orElseThrow(
                        () -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND))
                .getReviews().forEach(
                        r -> System.out.println("reviewId : " + r.getId() + ", restaurantId : " + r.getStore().getId()));
        storeRepository.findById(1L).orElseThrow(
                        () -> new TempHandler(ErrorStatus.RESTAURANT_NOT_FOUND))
                .getReviews().forEach(
                        r -> System.out.println("reviewId : " + r.getId() + ", memberId : "  + r.getMember().getId()));
    }
}
