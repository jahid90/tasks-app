FROM adoptopenjdk:16-jdk-openj9 as builder

WORKDIR /artifacts

# COPY build.gradle settings.gradle gradlew* gradle/ ./
# RUN ./gradlew build

COPY . ./
RUN ./gradlew bootJar

FROM adoptopenjdk:16-jre-openj9

WORKDIR /app

COPY --from=builder /artifacts/build/libs/*.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]
