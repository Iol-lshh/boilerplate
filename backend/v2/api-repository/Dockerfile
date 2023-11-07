# 멀티스테이지 빌드의 첫 번째 스테이지
FROM gradle:jdk17-alpine as builder
WORKDIR /build

# Gradle 프로젝트의 빌드 파일 및 소스 코드를 복사합니다.
COPY build.gradle settings.gradle ./
COPY src/ ./src/

# 프로젝트를 빌드합니다.
RUN gradle build

# 두 번째 스테이지: 빌드된 어플리케이션을 실행하는 베이스 이미지
FROM openjdk:17-slim
WORKDIR /app

# 빌드된 어플리케이션 JAR 파일을 복사합니다.
COPY --from=builder /build/build/libs/api-repository-0.0.1-SNAPSHOT.jar app.jar

# 어플리케이션을 실행합니다.
CMD ["java", "-jar", "app.jar"]
