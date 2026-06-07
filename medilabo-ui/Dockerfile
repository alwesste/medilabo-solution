FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package -DskipTests

FROM eclipse-temurin:21.0.11_10-jre-ubi9-minimal
WORKDIR /app
COPY --from=builder /app/target/*.jar medilabo-ui.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "medilabo-ui.jar" ]