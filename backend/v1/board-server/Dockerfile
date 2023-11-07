# 베이스 이미지
FROM eclipse-temurin:17-jre AS base
# 경로
ARG JAR_FILE="build/libs/board-server-0.0.1-SNAPSHOT.jar"
# 복사
COPY ${JAR_FILE} board-server.jar
# 실행
ENTRYPOINT ["java","-jar","/board-server.jar"]
