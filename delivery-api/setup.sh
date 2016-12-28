#!/bin/bash

docker build . --tag kenfos-mysql
docker run --name kenfos -p3306:3306 -d kenfos-mysql