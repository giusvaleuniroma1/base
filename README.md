# Distributed Anomaly Detection

## Overview

This is the base project to build the Microservices in the our distributed architecture.
Here are inserted the most used libraries with the same version.

## Prerequisites

- [Java 21](https://openjdk.java.net/projects/jdk/21/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)

## Getting Started

1. Clone the project:

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

    Ensure that the build completes successfully.

3. Install Docker:

    - Follow the Docker installation instructions for your operating system: [Docker Installation Guide](https://docs.docker.com/get-docker/)

4. Run RabbitMQ in a Docker container:

    ```bash
    docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
    ```

    This command pulls and starts the RabbitMQ Docker container.

    Setup the rabbitmq queue in the management console

5. Configure RabbitMQ in your Spring Boot application:

    Open the `application.properties` file and set the RabbitMQ connection properties:

    ```properties
    spring.rabbitmq.host=localhost
    spring.rabbitmq.port=5672
    spring.rabbitmq.username=guest
    spring.rabbitmq.password=guest
    ```

    Ensure that `spring.rabbitmq.host` matches the name or IP address of your RabbitMQ container.

6. Start your Spring Boot application:

    ```bash
    mvn spring-boot:run
    ```

    The application should start, producing and consuming messages to/from RabbitMQ.

## Usage

    Open your browser and going on http://localhost:8080
    Here you can see the SHA256 if a random string, and if is the same of the SHA256 that appears on the terminal, the application is setupped right!


## Contributing


## License

Copyright [2024] [Giuseppe Valente <valentepeppe@gmail.com>]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.