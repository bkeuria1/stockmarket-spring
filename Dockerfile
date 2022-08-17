FROM openjdk:11
COPY /target/SpringStockMarket-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]