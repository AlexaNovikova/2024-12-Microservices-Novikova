FROM bellsoft/liberica-openjdk-alpine-musl:21.0.1
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8000

ENV DB_HOST=""
ENV DB_PORT=""
ENV DB_NAME=""
ENV DB_SCHEMA=""
ENV DB_USERNAME=""
ENV DB_PASSWORD=""

ENTRYPOINT ["java","-jar","/app.jar"]