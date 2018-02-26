# Config

This is the sample config server project

## Index
1. [Introduction](#introduction)
2. [Prerequisite](#prerequisite)
3. [Building the application](#building-the-application)
4. [Running the application](#running-the-application)
5. [Endpoints](#endpoints)
6. [Furthur Reading](#further-reading)
7. [Reference](#reference)

## Introduction

This _microservice_ acts as the __config-server__ for the other microservies

## Prerequisite 
These are the reqired artifacts to run the application,
1. Java 1.8
2. Maven

## Building the application
Use maven to build the application,
```
mvn clean install 
```

## Running the application
Run the application using,
```sh
mvn spring-boot:run
```
Access the application at http://localhost:8888/config/info

## Endpoints

### Application config file 
To access the __client__ microservice config file
```
http://localhost:8888/config/client/default
or
http://localhost:8888/config/client/master
```
Since no active profile set

### Boot-admin
When spring boot admin is running access __Spring boot UI__ at,
```
http://localhost:1111
```
## Furthur reading

Spring Cloud Config Server exposes the following REST endpoints to get application specific configuration properties:
```
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
```
Here ```{application}``` refers to value of ```spring.config.name property```, ```{profile}``` is an ```active profile``` and ```{label}``` is an ```optional git label``` (defaults to “master”).

## Reference
* https://sivalabs.in/2017/08/spring-cloud-tutorials-introduction-to-spring-cloud-config-server/
* http://callistaenterprise.se/blogg/teknik/2017/05/12/building-microservices-part-6-configuration-server/