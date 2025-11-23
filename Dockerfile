FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/cadastro-service-0.0.1-SNAPSHOT.jar /app/AGENDAMENTO_CADASTRO_USUARIO.jar

EXPOSE 8080

CMD [ "java", "-jar", "/app/AGENDAMENTO_CADASTRO_USUARIO.jar" ]