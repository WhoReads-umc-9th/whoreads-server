package whoreads.backend.domain.notification.controller.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestParam;
import whoreads.backend.global.response.ApiResponse;
import io.swagger.v3.oas.annotations.Parameter;

@Tag(name = "Notification (알림) ", description = "알림 설정 및 발송 API")
public interface NotificationControllerDocs {

    @Operation(summary = "알림 발송 api (테스트용)", description = "사용자의 기기에 알림을 발송합니다.")
    ApiResponse<Void> sendMessage(
            @Parameter(description = "제목") @RequestParam String title,
            @Parameter(description = "내용") @RequestParam(required = false) String body,
            @Parameter(description = "fcm 토큰") @RequestParam String fcmToken,
            @Parameter(description = "링크") @RequestParam(required = false) String link
    );
}