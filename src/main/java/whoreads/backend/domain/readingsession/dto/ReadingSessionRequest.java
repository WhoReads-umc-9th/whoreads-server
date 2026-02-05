package whoreads.backend.domain.readingsession.dto;

import lombok.Getter;

public class ReadingSessionRequest {

    @Getter
    public static class Start {
        private Long memberId;
    }
}
