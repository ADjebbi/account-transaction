# Account Manager Service

## Prerequisites
* Java 17
* Docker +20.10
* Docker compose +v2.12
* Maven 3.6.3

## Build

    mvn clean install

## Run

    mvn clean install && java -jar

## How to connect to the Database 

Navigate through the following link to the browser : 
http://localhost:8060/h2-console
fill out the DB url and credentials and connect

    url: jdbc:h2:mem:account
    username: sa
    password: password
    driver-class-name: org.h2.Driver

## Docker image

    docker build -t harvest/account-manager/image .

## Swagger
Navigate the following link
    [http://localhost:8060/swagger-ui/index.html]()