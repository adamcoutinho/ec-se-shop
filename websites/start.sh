#!/bin/zsh
# script for export app building for enviroment local
docker image build -t ecommerce/website .
# start container
docker container run -p 3000:3000 -d ecommerce/website
#docker container run -it --publish 8080:8080 ecommerce/website