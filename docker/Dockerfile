FROM adoptopenjdk:11-jre-hotspot

RUN mkdir /opt/app

COPY ingredient.jar /opt/app

EXPOSE 8081

CMD ["java", "-jar", "/opt/app/ingredient.jar"]