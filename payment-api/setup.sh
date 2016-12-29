#!/bin/bash

ENVIRONMENT=${1:-'production'}
PORT=${2:-9999}

docker build . --build-arg ENVIRONMENT=${ENVIRONMENT} --tag payment-api
docker run --name payment-api -p${PORT}:9999 -d payment-api
