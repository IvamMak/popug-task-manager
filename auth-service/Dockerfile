FROM openjdk:17-alpine

ENV APP_HOME=/usr/src/auth-service

RUN mkdir -p $APP_HOME

WORKDIR $APP_HOME

COPY build.gradle settings.gradle gradlew $APP_HOME/
COPY gradle $APP_HOME/gradle
COPY src $APP_HOME/src

RUN ./gradlew bootJar

ARG JAR_FILE=build/libs/*.jar
COPY --from=build /build/libs/*.jar auth-service.jar

CMD ["java", "-jar", "auth-service.jar"]
