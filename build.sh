#!/bin/bash

./gradlew clean bootRepackage

docker build --rm . --tag coney/user-service:${VER:?invalid version}
#docker push coney/user-service:${VER:?invalid version}

export VER
docker stack deploy todo -c docker-compose.yml