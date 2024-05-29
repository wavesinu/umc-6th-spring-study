package com.study.app.web.controller;

import com.study.app.converter.StoreConverter;
import com.study.app.converter.ReviewConverter;
import com.study.app.domain.Store;
import com.study.app.domain.Review;
import com.study.app.service.store.StoreCommandService;
import com.study.app.service.store.StoreQueryService;
import com.study.app.web.dto.StoreRequest;
import com.study.app.web.dto.StoreResponse;
import com.study.app.web.dto.ReviewResponse;
import com.study.global.apiPayLoad.ApiResponse;
import com.study.global.validation.annotation.ExistRestaurant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
@Validated
public class StoreRestController {
    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;

    @PostMapping("/")
    public ApiResponse<StoreResponse.addStoreResultDTO> addStore(
            @RequestBody @Valid StoreRequest.addStoreDTO request
    ){
        Store store = storeCommandService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toAddStoreResultDTO(store));
    }

    @GetMapping("/{restaurantId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다.")
    })
    public ApiResponse<ReviewResponse.ReviewPreviewListDTO> getReviewList(
            @ExistRestaurant @PathVariable(name = "restaurantId") Long restaurantId,
            @RequestParam(name = "page") Integer page
    ){
        Page<Review> reviewPage = storeQueryService.getReviewList(restaurantId, page);
        return ApiResponse.onSuccess(ReviewConverter.toReviewPreviewListDTO(reviewPage));
    }

}
