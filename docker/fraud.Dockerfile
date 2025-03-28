FROM eclipse-temurin:17-jdk-jammy AS fraud-build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
COPY services/fraud $HOME
RUN --mount=type=cache,target=/root/.m2 $HOME/mvnw -f $HOME/pom.xml clean package

FROM eclipse-temurin:17-jre-jammy AS fraud-dev
ARG JAR_FILE=/usr/app/target/*.jar
COPY --from=fraud-build $JAR_FILE /app/runner.jar
EXPOSE 8081
CMD ["java", "-jar", "/app/runner.jar"]