package whoreads.backend.domain.notification.service;


import whoreads.backend.domain.notification.dto.FcmMessageDTO;

public interface NotificationPushService {

   void sendNotification(String fcmToken, FcmMessageDTO dto);
}
