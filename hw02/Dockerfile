FROM bellsoft/liberica-openjdk-alpine-musl:21.0.1
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","/app.jar"]