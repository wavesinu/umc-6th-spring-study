package com.study.app.web.controller;

import com.study.app.converter.ReviewConverter;
import com.study.app.domain.Review;
import com.study.app.repository.ReviewRepository;
import com.study.app.service.review.ReviewCommandService;
import com.study.app.web.dto.ReviewRequest;
import com.study.app.web.dto.ReviewResponse;
import com.study.global.apiPayLoad.ApiResponse;
import com.study.global.validation.annotation.ExistMember;
import com.study.global.validation.annotation.ExistRestaurant;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@Validated
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;
    private final ReviewRepository reviewRepository;

    @PostMapping("")
    public ApiResponse<ReviewResponse.AddReviewResultDTO> addReview(
            @RequestParam(value = "memberId", required = true) @ExistMember Long memberId,
            @RequestParam(value = "restaurantId", required = true) @ExistRestaurant Long restaurantId,
            @RequestBody @Valid ReviewRequest.AddReviewDTO request
    ) {
        Review review = reviewCommandService.addReview(memberId, restaurantId, request);
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(review));
    }


    @DeleteMapping("")
    public String deleteReview(
            @RequestParam(value = "reviewId", required = true) @Valid Long reviewId
    ) {
        reviewRepository.deleteById(reviewId);
        reviewCommandService.check2();
        return "삭제 OK";
    }


}
