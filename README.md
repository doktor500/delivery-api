Delivery API
============

Requirements
--------------

* Git
* Bash
* Java 8
* NodeJs 5.6.0
* MySQL 5.7
* Docker

### Setup payment-api

	cd payment-api/src
	npm install -g nodemon && npm install

### Setup delivery-api

Add to `/etc/hosts`

    127.0.0.1             delivery-api-db
    127.0.0.1             payment-api

Run

	cd delivery-api
	keytool -importcert -keystore $JAVA_HOME/jre/lib/security/cacerts -file betamax.pem -alias betamax -storepass changeit -noprompt
	
Setup MySQL locally or with Docker following:

	docker build docker/mysql --tag delivery-api-db
	docker run --name delivery-api-mysql -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -p 3306:3306 -d delivery-api-db


### Run payment-api

    cd payment-api/src
    nodemon app.js
    
### Run delivery-api

	cd delivery-api
	./gradlew bootRun

### Run delivery-api with an in-memory DB

	cd delivery-api
	SPRING_PROFILES_ACTIVE=h2-db ./gradlew bootRun

### Run tests on delivery-api (if default payment-api is up and running)

	cd delivery-api
	./gradlew test

### Run tests on delivery-api (with a fake implementation of payment-api)

	cd delivery-api
	SPRING_PROFILES_ACTIVE=fake-payment-service ./gradlew test
