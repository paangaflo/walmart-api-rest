# Walmart API

API REST application for product search. This is a repository for Dockerizing a Maven Spring-Boot Application.

## Getting Started

Clone repository to local environment.

### Prerequisites

What things you need to install the software:

Need to know Java SE and what a Maven project is and some Spring-boot.

- [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Docker](https://www.docker.com/get-docker)

### Build in local environment

Be sure to build project with Maven; you can build project directly from your preferred IDE; if have Maven configured in their local environment you can build the project with the following command.

```
mvn clean install
```

### Running project with Docker

We need to build the image by executing:
```
docker build -t api .
```
The `-t <name>` just gives our image a name.

After Docker has build successfully, now we need to run the docker image
when doing so it creates a container.

Now we are going to create a container for  database and for REST API application. Command will create one container for database and one for spring-boot app as defined in docker-compose file.

```
docker-compose up
```

The application will start now you test in your browser by going to:

```
http://localhost:8080/api/products
```

To add a search criterion only have to use parameter:
(xyz is any word)
```
http://localhost:8080/api/products?search=xyz
```

If you want to see documentation online with UI Swagger you can enter the following link:

```
localhost:8080/swagger-ui.html
```
## Built With

* [Spring Tools](https://spring.io/tools) - The IDE used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Docker](https://www.docker.com/get-docker)
* [Spring Boot](https://spring.io/guides/gs/spring-boot/)

## Authors

* **Pablo Galvis** - [paangaflo](https://github.com/paangaflo)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details