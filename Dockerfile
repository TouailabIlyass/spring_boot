FROM maven:3.3.9-jdk-8-alpine as build-env
COPY . /app
WORKDIR /app
RUN mvn package

FROM openjdk:8-jdk-alpine
WORKDIR /app
CMD java -jar app.war
COPY --from=build-env /app/target/*.war app.war