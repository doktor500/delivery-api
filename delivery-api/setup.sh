#!/bin/bash

docker build . --tag kenfos-mysql
docker run --name kenfos -p3306:3306 -d kenfos-mysql

rm betamax.pem 2> /dev/null
wget -q https://raw.githubusercontent.com/betamaxteam/betamax/master/betamax.pem
keytool -importcert -keystore $JAVA_HOME/jre/lib/security/cacerts -file betamax.pem -alias betamax -storepass changeit -noprompt > /dev/null
