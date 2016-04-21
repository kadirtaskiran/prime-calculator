# Prime Calculator Example
A complete Prime Calculator example application with Spring Boot for REST APIs; its purpose is to demonstrate various API documentation tools.

## Installation
* Ensure that Java 8 and Maven 3.2 are installed
* Docker service installed and running

## Usage
### Running the Spring Boot app
Navigate to the directory into which you cloned the repo and execute this:
```
mvn spring-boot:run
```

Once started you can access the APIs on port 9080, e.g.
```
http://localhost:9080/prime/basic/10
http://localhost:9080/prime/parallel/10
http://localhost:9080/prime/stream/10
http://localhost:9080/prime/stream/parallel/10
```


### How to build docker image
```
mvn package
```
Set Docker host informations first for Kitematic
```
bash -c "clear && DOCKER_HOST=tcp://192.168.99.100:2376 DOCKER_CERT_PATH=/Users/user-name/.docker/machine/machines/default DOCKER_TLS_VERIFY=1 /bin/bash"
```
```
mvn docker:build
```

### How to run docker container
```
docker run -d --name prime -p 9080:9080 prime-calculator
```

Once run a Docker container you can access the APIs on port 9080, e.g.
```
http://192.168.99.100:9080/prime/basic/10
http://192.168.99.100:9080/prime/parallel/10
http://192.168.99.100:9080/prime/stream/10
http://192.168.99.100:9080/prime/stream/parallel/10
```


The port number can be changed by editing the port property in `src/main/resources/application.yml`

### Convert Swagger spec into HTML doc
The swagger2markup and asciidoc maven plugins are used to publish the API documentation as an HTML doc. To use:

`mvn clean test site`

This will create the HTML doc in `target/generated-docs/html`
