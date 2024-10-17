FROM openjdk:21-jdk

WORKDIR /app

COPY target/*.jar app.jar

ENV URL_CLOUD ${URL_CLOUD}
ENV URL_END ${URL_END}
ENV URL_MONGO ${URL_MONGO}

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "app.jar"]
