package com.study.app.service.review;

import com.study.app.domain.Review;
import com.study.app.web.dto.ReviewRequest;

public interface ReviewCommandService {
    Review addReview(Long memberId, Long restaurantId, ReviewRequest.AddReviewDTO request);

    void check(Long memberId, Long restaurantId, ReviewRequest.AddReviewDTO request);

    void check2();
}
