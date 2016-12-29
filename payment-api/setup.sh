#!/bin/bash

docker build . --tag payment-api
docker run --name payment-api -p9999:9999 -d payment-api
