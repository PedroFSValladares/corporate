FROM maven:3.8.5-openjdk-17 AS BUILD
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM ubuntu/jre:17-22.04_edge
WORKDIR /app
COPY ./Dados/ /app/Dados
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]