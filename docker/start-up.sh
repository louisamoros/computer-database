#!/bin/bash

docker-compose up -d

echo -n "Docker hub password: "
read -s password

docker exec jenkins-cdb docker login --username="louisamoros" --email="amoros.louis@gmail.com" --password="$password"
