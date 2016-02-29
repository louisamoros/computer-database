#!/bin/bash

echo -n "Docker hub password: "
read -s PASSWORD

echo "Sending credentials to container..."
docker exec jenkins-cdb docker login --username="louisamoros" --email="amoros.louis@gmail.com" --password="$PASSWORD"

