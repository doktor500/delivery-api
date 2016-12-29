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

### Run delivery-api

	cd delivery-api
	./gradlew bootRun

### Run delivery-api with in-memory DB

	cd delivery-api
	SPRING_PROFILES_ACTIVE=h2-db ./gradlew bootRun

### Run tests on delivery-api (if default payment-api is up and running)

	cd delivery-api
	./gradlew test

### Run tests on delivery-api (with a fake implementation of payment-api)

	cd delivery-api
	SPRING_PROFILES_ACTIVE=fake-payment-service ./gradlew test
