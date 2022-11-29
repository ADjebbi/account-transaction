FROM amazoncorretto:17-alpine3.15

WORKDIR /app
COPY target/*.jar /app/transactionRequest-manager-0.0.1-SNAPSHOT.jar

CMD java $JAVA_OPTS -jar *.jar