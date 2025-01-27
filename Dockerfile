# Maven 빌드 환경 (Java 11)
FROM maven:3.9.9-amazoncorretto-11-alpine AS builder

# PostgreSQL 클라이언트 설치
RUN apk add --no-cache postgresql-client

# 작업 디렉토리 설정
WORKDIR /app

# Maven 프로젝트 복사
COPY . .

# 프로젝트 빌드
RUN mvn package -DskipTests

# 런타임 환경 (Amazon Corretto 11)
FROM amazoncorretto:11-alpine

# 빌드 결과물 복사
COPY --from=builder /app/target/*.jar /app/your-application.jar

# 애플리케이션 실행
CMD ["java", "-jar", "/app/your-application.jar"]


# 애플리케이션에서 사용하는 포트를 노출
EXPOSE 8080
