package whoreads.backend.domain.notification.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.Random;

@Getter
@RequiredArgsConstructor
public enum NotificationMessageType {
    NEW_FOLLOW_BOOK("%s의 서재에 새 책이 추가됐어요!", "『%s』%s"),

    BOOK_ROUTINE("독서 루틴 알림", "") {
        private final String[][] messages = {
                {"미리 정해 둔 독서 시간이에요", "오늘도 부담 없이 시작해 보세요"},
                {"설정해 둔 독서 시간이 되었어요", "잠깐이라도 책을 펼쳐보세요."},
                {"설정한 독서 루틴 시간이에요.", "오늘의 독서를 가볍게 시작해 보세요."}
        };

        @Override
        public String[] generate(Object... args) {
            int randomIndex = new Random().nextInt(messages.length);
            return messages[randomIndex];
        }
    };

    private final String titleTemplate;
    private final String bodyTemplate;

    public String[] generate(Object... args) {
        return new String[]{
                String.format(titleTemplate, args),
                String.format(bodyTemplate, args)
        };
    }
}