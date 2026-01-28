package whoreads.backend.global.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import whoreads.backend.global.exception.CustomException;
import whoreads.backend.global.exception.ErrorCode;

import java.io.IOException;

@Slf4j
@Configuration
public class FirebaseConfig {
    @Value("${firebase.secret.path}")
    private String serviceAccountPath;

    @Bean
    public FirebaseApp firebaseApp() {
        try {
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(
                            GoogleCredentials.fromStream(new ClassPathResource(serviceAccountPath).getInputStream())
                    )
                    .build();

            return FirebaseApp.initializeApp(options);

        } catch (IOException exception) {
            throw new CustomException(ErrorCode.FCM_SERVER_UNAVAILABLE);
        }
    }

    @Bean
    public FirebaseMessaging firebaseMessaging(FirebaseApp firebaseApp) {
        return FirebaseMessaging.getInstance(firebaseApp);
    }
}