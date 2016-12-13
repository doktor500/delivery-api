Delivery API
============

Requirements
--------------

* Bash
* Git
* Java 8
* MySQL 5.7
* NodeJs 5.6.0

### Setup payment-api

	cd payment-api
	npm install
	node app.js

### Setup delivery-api

	cd delivery-api
	./scripts/db-reset

### Run tests on delivery-api (with payment-api running)

	cd delivery-api
	./gradlew test
