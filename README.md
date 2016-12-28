Delivery API
============

Requirements
--------------

* Git
* Java 8
* NodeJs 5.6.0
* Docker

### Setup payment-api

	cd payment-api
	npm install
	node app.js

### Run Application

	cd delivery-api
	./gradlew bootRun

### Run Application with in-memory DB

	cd delivery-api
	./gradlew bootRun -Dspring.profiles.active=h2-db

### Run tests on delivery-api (with payment-api running)

	cd delivery-api
	./gradlew test
