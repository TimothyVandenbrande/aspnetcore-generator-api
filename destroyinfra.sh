#!/bin/bash

home_dir=`pwd`

echo "Destroy the swarm"
cd $home_dir/infra/swarm
vagrant destroy -f
export DOCKER_HOST=

echo "Destroy Teamcity"
cd $home_dir/infra/teamcity
docker-compose down --rmi all

echo "Destroy local registry"
cd $home_dir/infra/registry
docker-compose down --rmi all


