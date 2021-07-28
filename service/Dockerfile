FROM adoptopenjdk:16-jre-openj9

WORKDIR /app

COPY ./build/libs/*.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]
