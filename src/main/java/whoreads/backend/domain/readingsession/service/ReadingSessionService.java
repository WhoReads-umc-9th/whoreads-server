package whoreads.backend.domain.readingsession.service;

import whoreads.backend.domain.readingsession.dto.ReadingSessionResponse;

public interface ReadingSessionService {

    ReadingSessionResponse.StartResult startSession(Long memberId);

    void pauseSession(Long sessionId);

    void resumeSession(Long sessionId);

    void completeSession(Long sessionId);
}
