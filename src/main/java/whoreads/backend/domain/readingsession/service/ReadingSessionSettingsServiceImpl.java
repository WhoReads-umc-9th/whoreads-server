package whoreads.backend.domain.readingsession.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import whoreads.backend.domain.readingsession.dto.ReadingSessionResponse;

@Service
@RequiredArgsConstructor
public class ReadingSessionSettingsServiceImpl implements ReadingSessionSettingsService {

    @Override
    public ReadingSessionResponse.FocusBlockSetting getFocusBlockSetting() {
        // TODO: 실제 구현 시
        // 1. 로그인한 사용자 조회
        // 2. Member.focusBlockEnabled 값 반환

        // Mock: 기본값 false
        return ReadingSessionResponse.FocusBlockSetting.builder()
                .focusBlockEnabled(false)
                .build();
    }

    @Override
    public ReadingSessionResponse.FocusBlockSetting updateFocusBlockSetting(Boolean focusBlockEnabled) {
        // TODO: 실제 구현 시
        // 1. 로그인한 사용자 조회
        // 2. Member.focusBlockEnabled 업데이트
        // 3. 변경된 값 반환

        // Mock: 요청값 그대로 반환
        return ReadingSessionResponse.FocusBlockSetting.builder()
                .focusBlockEnabled(focusBlockEnabled)
                .build();
    }

    @Override
    public ReadingSessionResponse.WhiteNoiseSetting getWhiteNoiseSetting() {
        // TODO: 실제 구현 시
        // 1. 로그인한 사용자 조회
        // 2. Member.whiteNoiseEnabled 값 반환

        // Mock: 기본값 false
        return ReadingSessionResponse.WhiteNoiseSetting.builder()
                .whiteNoiseEnabled(false)
                .build();
    }

    @Override
    public ReadingSessionResponse.WhiteNoiseSetting updateWhiteNoiseSetting(Boolean whiteNoiseEnabled) {
        // TODO: 실제 구현 시
        // 1. 로그인한 사용자 조회
        // 2. Member.whiteNoiseEnabled 업데이트
        // 3. 변경된 값 반환

        // Mock: 요청값 그대로 반환
        return ReadingSessionResponse.WhiteNoiseSetting.builder()
                .whiteNoiseEnabled(whiteNoiseEnabled)
                .build();
    }
}
