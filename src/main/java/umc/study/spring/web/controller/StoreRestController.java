package umc.study.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.spring.apiPayload.ApiResponse;
import umc.study.spring.converter.StoreConverter;
import umc.study.spring.domain.Review;
import umc.study.spring.domain.Store;
import umc.study.spring.service.StoreService.StoreCommandService;
import umc.study.spring.service.StoreService.StoreQueryService;
import umc.study.spring.validation.annotation.ExistStore;
import umc.study.spring.web.dto.StoreRequestDTO;
import umc.study.spring.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {
    private  final StoreCommandService storeCommandService;

    private final StoreQueryService storeQueryService;

    @GetMapping("/{storeId}/reviews")
    @Operation(summary="특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query string으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode="COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003",description="access 토큰을 주세요!", content=@Content(schema=@Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004",description="access 토큰 만료", content=@Content(schema=@Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006",description = "access 토큰 모양이 이상함",content=@Content(schema=@Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name="storeId",description="가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name="storeId")Long storeId,@RequestParam(name="page", defaultValue = "0") Integer page){
        Page<Review> reviewList=storeQueryService.getReviewList(storeId,page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }



}
