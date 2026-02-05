package whoreads.backend.domain.readingsession.dto;

import lombok.Getter;

public class ReadingSessionRequest {

    @Getter
    public static class Start {
        private Long memberId;
    }

    @Getter
    public static class UpdateFocusBlock {
        private Boolean focusBlockEnabled;
    }

    @Getter
    public static class UpdateWhiteNoise {
        private Boolean whiteNoiseEnabled;
    }
}
