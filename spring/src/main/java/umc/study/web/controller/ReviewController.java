package umc.study.web.controller;

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
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.RestaurantConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Mission;
import umc.study.validation.annotation.ExistRestaurant;
import umc.study.web.dto.RestaurantResponseDTO;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.service.ReviewService.ReviewQueryService;
import org.springframework.web.bind.annotation.*;
import umc.study.domain.Review;
import umc.study.web.dto.ReviewResponseDTO;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    @PostMapping("/restaurant/{restaurantId}")
    @Operation(summary = "리뷰 작성 API",description = "특정 가게에 리뷰를 작성하는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewWritingResultDTO> createReview(
            @PathVariable Long restaurantId,
            @RequestBody @Valid ReviewRequestDTO.ReviewWritingDTO request) {

        Review review = reviewQueryService.createReview(request, restaurantId);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResponse(review));

    }

    @GetMapping("")
    @Operation(summary = "사용자 리뷰 목록 조회 API",description = "사용자가 작성한 리뷰 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<ReviewResponseDTO.UserReviewListDTO> getUserReviewList(@RequestParam(name = "page") Integer page){

        Page<Review> reviewList = reviewQueryService.getUserReviewList(1L, page);
        return ApiResponse.onSuccess(ReviewConverter.userReviewListDTO(reviewList));
    }
}
