package whoreads.backend.domain.readingsession.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import whoreads.backend.domain.readingsession.enums.SessionStatus;
import whoreads.backend.global.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "reading_session")
public class ReadingSession extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SessionStatus status;

    @Column(name = "total_minutes")
    private Integer totalMinutes;

    @Column(name = "finished_at")
    private LocalDateTime finishedAt;

    @OneToMany(mappedBy = "readingSession", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReadingInterval> intervals = new ArrayList<>();

    @Builder
    public ReadingSession(Long memberId) {
        this.memberId = memberId;
        this.status = SessionStatus.IN_PROGRESS;
        this.totalMinutes = 0;
    }

    public void pause() {
        this.status = SessionStatus.PAUSED;
    }

    public void resume() {
        this.status = SessionStatus.IN_PROGRESS;
    }

    public void complete(Integer totalMinutes) {
        this.status = SessionStatus.COMPLETED;
        this.totalMinutes = totalMinutes;
        this.finishedAt = LocalDateTime.now();
    }

    public void addInterval(ReadingInterval interval) {
        this.intervals.add(interval);
    }

    public int calculateTotalMinutes() {
        return this.intervals.stream()
                .filter(interval -> interval.getDurationMinutes() != null)
                .mapToInt(ReadingInterval::getDurationMinutes)
                .sum();
    }
}
