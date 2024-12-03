FROM openjdk:17-alpine

MAINTAINER 2024_6SOAT

ARG AWS_ACCESS_KEY2
ARG AWS_SECRET_ACCESS2

ENV AWS_ACCESS_KEY=${AWS_ACCESS_KEY2}
ENV AWS_SECRET_ACCESS=${AWS_SECRET_ACCESS2}

COPY ./target/shogun-lanches-pedido-1.jar app.jar

ENV SPRING_PROFILES_ACTIVE=prod

ENTRYPOINT ["java", "-jar", "/app.jar"]

EXPOSE 8080