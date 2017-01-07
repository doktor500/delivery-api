FROM openjdk:8u111

COPY . /opt/apps/delivery-api
COPY docker/wait-for-it.sh /usr/local/bin/wait-for-it.sh
WORKDIR /opt/apps/delivery-api

RUN keytool -importcert -keystore /usr/lib/jvm/java-8-openjdk-amd64/jre/lib/security/cacerts -file betamax.pem -alias betamax -storepass changeit -noprompt && \
    ./gradlew -Dspring.profiles.active=fake-payment-service,h2-db clean build

CMD /usr/local/bin/wait-for-it.sh delivery-api-db:3306 --timeout=60 && \
    java -jar build/libs/delivery-api-0.1.0.jar

EXPOSE 8080
