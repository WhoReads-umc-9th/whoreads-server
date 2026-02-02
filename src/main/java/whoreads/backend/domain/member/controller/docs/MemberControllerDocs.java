package whoreads.backend.domain.member.controller.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import whoreads.backend.domain.member.dto.MemberRequest;
import whoreads.backend.global.response.ApiResponse;

@Tag(name = "Member (사용자)")
public interface MemberControllerDocs {

    @Operation(summary = "토큰 업데이트",
            description = "푸시 알림 발송에 필요한 토큰을 등록 또는 업데이트 합니다.")
    @ApiResponses(
            {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            })
    ApiResponse<Void> updateFcmToken(
            @AuthenticationPrincipal Long memberId,
            @RequestBody MemberRequest.FcmTokenRequest request
    );
    @Operation(summary = "토큰 삭제",
            description = "사용자가 앱을 삭제하거나 로그아웃 할 시 토큰을 삭제합니다.")
    @ApiResponses(
            {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            })
    ApiResponse<Void> deleteFcmToken(@AuthenticationPrincipal Long memberId);
}