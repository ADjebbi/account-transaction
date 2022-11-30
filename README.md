# account-transaction Service

## Prerequisites

* Java 17
* Docker +20.10
* Docker compose +v2.12
* Maven 3.6.3
* Create account-manager and transaction-manage images

## Deploy with Docker compose

    sudo docker-compose -f docker/app.yml up -d

## Stop services

    sudo docker-compose -f docker/app.yml stop account-manager
    sudo docker-compose -f docker/app.yml stop transaction-manage

## Remove services

    sudo docker-compose -f docker/app.yml rm account-manager
    sudo docker-compose -f docker/app.yml rm transaction-manage
