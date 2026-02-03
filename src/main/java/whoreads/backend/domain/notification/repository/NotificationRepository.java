package whoreads.backend.domain.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import whoreads.backend.domain.notification.entity.Notification;
import whoreads.backend.domain.notification.enums.NotificationType;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    @Query("SELECT n FROM Notification n WHERE n.member.id = :userId " +
            "AND (:type IS NULL OR n.type = :type)")
    List<Notification> findAllByUserIdAndOptionalType(
            Long userId,
            NotificationType type
    );
}
