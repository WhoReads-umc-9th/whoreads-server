package whoreads.backend.domain.notification.dto;

import lombok.Builder;
import lombok.Getter;
import whoreads.backend.domain.notification.enums.NotificationType;

import java.util.Map;

@Getter
@Builder
public class FcmMessageDTO {
    private final String title;
    private final String body;
    private final String link;
    private final String type;
    private final Map<String, String> data;

    // NotificationTypes(상위 타입)를 받아서 메시지를 생성하도록 변경
    public static FcmMessageDTO of(NotificationType type, String link, Object... args) {
        // 아까 연결한 메서드 호출
        String[] generated = type.generateMessage(args);

        return FcmMessageDTO.builder()
                .title(generated[0])
                .body(generated[1])
                .type(type.name()) // DB 저장용 타입 이름 (FOLLOW, ROUTINE 등)
                .link(link)
                .build();
    }
}