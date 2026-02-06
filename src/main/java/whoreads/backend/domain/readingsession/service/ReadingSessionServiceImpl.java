package whoreads.backend.domain.readingsession.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import whoreads.backend.domain.readingsession.dto.ReadingSessionResponse;
import whoreads.backend.domain.readingsession.repository.ReadingSessionRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ReadingSessionServiceImpl implements ReadingSessionService {

    private final ReadingSessionRepository readingSessionRepository;

    @Override
    public ReadingSessionResponse.StartResult startSession(Long memberId) {
        // TODO: 실제 구현 시
        // 1. memberId로 회원 조회
        // 2. ReadingSession 생성 (IN_PROGRESS)
        // 3. ReadingInterval 생성 (startTime = now)

        return ReadingSessionResponse.StartResult.builder()
                .sessionId(1L)
                .build();
    }

    @Override
    public void pauseSession(Long sessionId) {
        // TODO: 실제 구현 시
        // 1. sessionId로 세션 조회 (없으면 404)
        // 2. 상태가 IN_PROGRESS인지 확인
        // 3. 현재 진행중인 interval 종료 (endTime = now, durationMinutes 계산)
        // 4. 세션 상태를 PAUSED로 변경
    }

    @Override
    public void resumeSession(Long sessionId) {
        // TODO: 실제 구현 시
        // 1. sessionId로 세션 조회 (없으면 404)
        // 2. 상태가 PAUSED인지 확인
        // 3. 새 ReadingInterval 생성 (startTime = now)
        // 4. 세션 상태를 IN_PROGRESS로 변경
    }

    @Override
    public void completeSession(Long sessionId) {
        // TODO: 실제 구현 시
        // 1. sessionId로 세션 조회 (없으면 404)
        // 2. 진행중인 interval이 있으면 종료
        // 3. 모든 interval의 durationMinutes 합산
        // 4. 세션 상태를 COMPLETED로 변경, totalMinutes/finishedAt 설정
    }
}
