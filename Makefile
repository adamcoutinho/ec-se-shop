delete:
	./infra-local/delete-containers.sh
up:
	docker-compose up -d
down:
	docker-compose stop
build-project:
	gradle clean build
traefik:
	docker-compose -f traefik.yml up -d