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

import java.io.IOException;

@Slf4j
@Configuration
public class FirebaseConfig {
    @Value("${firebase.secret.path}")
    private String SERVICE_ACCOUNT_PATH;

    @Bean
    public FirebaseApp firebaseApp() {
        try {
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(
                            GoogleCredentials.fromStream(new ClassPathResource(SERVICE_ACCOUNT_PATH).getInputStream())
                    )
                    .build();

            return FirebaseApp.initializeApp(options);

        } catch (IOException exception) {
            return null;
        }
    }

    @Bean
    public FirebaseMessaging firebaseMessaging(FirebaseApp firebaseApp) {
        return FirebaseMessaging.getInstance(firebaseApp);
    }
}