Delivery API
============

Requirements
--------------

* Bash
* Git
* Java 8
* NodeJs 5.6.0
* Docker

### Setup payment-api

	cd payment-api
	npm install
	node app.js

### Setup delivery-api

	cd delivery-api
	./setup.sh

### Run Application

	cd delivery-api
	./gradlew bootRun

### Run Application with in-memory DB

	cd delivery-api
	./gradlew bootRun -Dspring.profiles.active=h2-db

### Run tests on delivery-api (with default payment-api up and running)

	cd delivery-api
	./gradlew test

### Run tests on delivery-api (with fake payment-api)

	cd delivery-api
	SPRING_PROFILES_ACTIVE=fake-payment-service ./gradlew test
