# Client

This is the sample client project

## Index
1. [Introduction](#introduction)
2. [Prerequisite](#prerequisite)
3. [Building the application](#building-the-application)
4. [Running the application](#running-the-application)
5. [Endpoints](#endpoints)

## Introduction

This _microservice_ is to process the file uploaded handled by __REST endpoint__

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
Access the application at http://localhost:8080/client/

## Endpoints

### Actuator endpoints enabled
Use actuator enpoints to access health,info,metrics,..
```
http://localhost:8080/client/health
http://localhost:8080/client/info
http://localhost:8080/client/metrics
```

### Swagger
Use the following endpoint,

```
http://localhost:8080/client/swagger-ui.html#/file-upload-controller
```

### Boot-admin
When spring boot admin is running access __Spring boot UI__ at,
```
http://localhost:1111
```
