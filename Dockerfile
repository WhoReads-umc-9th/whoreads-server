# Stage 1: Build
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Gradle Wrapper 복사 및 실행 권한 부여
COPY gradlew ./
COPY gradle ./gradle
RUN chmod +x ./gradlew

# Gradle 캐싱을 위해 의존성 파일 먼저 복사
COPY build.gradle settings.gradle ./

# 의존성 다운로드 (캐싱 활용)
RUN ./gradlew dependencies --no-daemon || true

# 소스 코드 복사 및 빌드
COPY src ./src
RUN ./gradlew bootJar --no-daemon -x test

# Stage 2: Run
FROM eclipse-temurin:21-jre

WORKDIR /app

# 빌드된 JAR 파일 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 포트 노출
EXPOSE 8080

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]
