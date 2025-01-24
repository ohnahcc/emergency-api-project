# Java 11 이미지를 사용합니다.
FROM openjdk:11-jdk-slim

# JAR 파일을 컨테이너 내부로 복사합니다.
COPY target/emergency-api-project-1.0-SNAPSHOT.jar /app/your-application.jar

# 애플리케이션 실행 명령어
ENTRYPOINT ["java", "-jar", "/app/your-application.jar"]

# 애플리케이션에서 사용하는 포트를 노출합니다.
EXPOSE 8080