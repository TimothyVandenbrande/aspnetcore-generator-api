#!/bin/bash

export DOCKER_HOST=192.168.66.201
docker swarm init --advertise-addr 192.168.66.201
SWARM_TOKEN=$(docker swarm join-token worker -q)

export DOCKER_HOST=192.168.66.211
docker swarm join --token $SWARM_TOKEN  192.168.66.201:2377

export DOCKER_HOST=192.168.66.212
docker swarm join --token $SWARM_TOKEN  192.168.66.201:2377

export DOCKER_HOST=192.168.66.213
docker swarm join --token $SWARM_TOKEN  192.168.66.201:2377

export DOCKER_HOST=192.168.66.201
