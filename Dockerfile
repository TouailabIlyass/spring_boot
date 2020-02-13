FROM openjdk:8-jdk-alpine
WORKDIR /app
CMD java -jar app.war
COPY  ./target/*.war app.war

