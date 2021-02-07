#!/bin/bash

cd .. && ./gradlew clean assemble && cd docker
cp ../build/libs/ingredient-1.0-SNAPSHOT.jar ./ingredient.jar && \
  docker build -t ingredient-1.0-snapshot . && \
  rm ./ingredient.jar
docker image tag ingredient-1.0-snapshot:latest hakankaynar/ingredient:latest
docker push hakankaynar/ingredient:latest
