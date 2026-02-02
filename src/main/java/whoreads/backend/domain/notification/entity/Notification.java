package whoreads.backend.domain.notification.entity;

import jakarta.persistence.*;
import lombok.*;
import whoreads.backend.domain.member.entity.Member;
import whoreads.backend.domain.notification.enums.NotificationType;
import whoreads.backend.global.entity.BaseEntity;

import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    @Column(columnDefinition = "json")
    private List<String> days;

    private LocalTime time;

    @Column(name = "is_enabled", nullable = false)
    @Builder.Default
    private boolean isEnabled = true;

    public void updateEnabled(boolean isEnabled)
    {
        this.isEnabled = isEnabled;
    }
    public void updateRoutine(LocalTime time, List<String> days, boolean isEnabled) {
        this.time = time;
        this.days = days;
        this.isEnabled = isEnabled;
    }
}
