package whoreads.backend.domain.notification.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotificationType {
    // DB에는 "FOLLOW", "ROUTINE"으로 저장됨
    FOLLOW(NotificationMessageType.NEW_FOLLOW_BOOK),
    ROUTINE(NotificationMessageType.BOOK_ROUTINE);

    // 메시지 생성 로직을 담은 클래스와 연결
    private final NotificationMessageType messageType;

    // 편의를 위해 바로 메시지를 생성하는 메서드 추가
    public String[] generateMessage(Object... args) {
        return this.messageType.generate(args);
    }
}