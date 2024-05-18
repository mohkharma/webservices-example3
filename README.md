# Example 3 - sample project

<!-- TOC -->
* [Example 3](#example-3)
<!-- TOC -->

Project structure, **JPA** with relations and custom queries, consume external REST API.


```shell
git clone https://github.com/mohkharma/webservices-example3.git
cd webservices-example3
#Compiles the project, runs test cases, and packages the application as a JAR file located into the target directory.
.\mvnw package

#Build a Docker image using the Dockerfile

docker build -t example3:v1 .

# Run the Docker container, this command maps port 8080 on your host machine to port 8080 in the container, to allow accessing the application using http://localhost:8080.
docker run -it --detach --name example3 -p8080:8080 example3:v1

# Clean the project
./mvnw clean

#Stop the container
docker stop example3

#Remove the container
docker rm example3
```


### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.4/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
