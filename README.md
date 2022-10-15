# Purpose

This was a quick project I did to refresh my mind about jpa persistence. Been a
while I've had a project with it due to custom databases in previous projects

# Building

    ./mvnw clean install

This will install the output jar file into ./docker/ folder

# Running

    cd docker
    docker-compose up --build

Api endpoints listen in localhost:8080/api/movie/

See
[MovieController.java](src/main/java/fi/tapani/movie_service/controller/MovieController.java)
for what endpoints are available and their shape

# Testing

In addition to unit test there is a postman collection of requests in the docs
folder
