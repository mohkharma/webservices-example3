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
docker run -it -p8080:8080 example3:v1

# Clean the project
./mvnw clean
```

