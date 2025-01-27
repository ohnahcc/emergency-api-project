# 1단계: Maven을 이용해 빌드
FROM maven:3.8.8-openjdk-11 AS build
WORKDIR /app

# Maven 의존성 캐싱을 위해 먼저 pom.xml 복사
COPY pom.xml ./

# 의존성을 다운로드
RUN mvn dependency:go-offline

# 애플리케이션 소스를 복사하고 빌드 실행
COPY src ./src
RUN mvn clean package -DskipTests

# 2단계: JAR 파일을 실행하는 이미지 생성
FROM openjdk:11-jdk-slim
WORKDIR /app

# 빌드된 JAR 파일 복사
COPY --from=build /app/target/emergency-api-project-1.0-SNAPSHOT.jar ./your-application.jar

# 애플리케이션 실행 명령어
ENTRYPOINT ["java", "-jar", "your-application.jar"]

# 애플리케이션에서 사용하는 포트를 노출
EXPOSE 8080
