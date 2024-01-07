# Distributed Anomaly Detection

## Overview

This is the base project to build the Microservices in the our distributed architecture.
Here are inserted the most used libraries with the same version.

## Prerequisites

- [Java 21](https://openjdk.java.net/projects/jdk/21/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)

## Getting Started

1. Clone the project

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

    Ensure that the build completes successfully.

3. Install Docker:

    - Follow the Docker installation instructions for your operating system: [Docker Installation Guide](https://docs.docker.com/get-docker/)

4. Download and run the RabbitMQ container:
    ```bash
    #Run the following commands with a user that has the permissions to use docker (or superuser)
    docker pull rabbitmq:3-management
    docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:3-management
    ```

5. Setup the RabbitMQ queue:
    - Going on [RabbitMQ Management Console] (http://localhost:15672) and login with the default user (username = guest, password = guest)
    - Going on [Queue setup] (http://localhost:15672/#/queues) and instance a new queue named **rabbitmq**

6. Configure RabbitMQ in your Spring Boot application:

    Open the `application.properties` file and set the RabbitMQ connection properties:

    ```properties
    spring.rabbitmq.host=localhost # Change this value in production
    spring.rabbitmq.port=5672      # Change this value in production
    spring.rabbitmq.username=guest # Change this value in production
    spring.rabbitmq.password=guest # Change this value in production
    ```
    Ensure that `spring.rabbitmq.host` matches the name or IP address of your RabbitMQ container.

7. Start your Spring Boot application:

    ```bash
    mvn spring-boot:run
    ```

    The application should start, producing and consuming messages to/from RabbitMQ.

## Usage
  - Open your browser and going on http://localhost:8080

  - When the page is loaded in you can see a SHA-256 string, that is computed at runtime from the Producer spring component **RabbitMQProducer**. 

  - The hased string is sent from the Producer to the Consumer **RabbitMqConsumer** through the rabbitmq queue (step 5), then is printed by the Consumer in the terminal.
    
  - If the SHA-256 code is the same (browser and terminal) the application works well!
  
## Contribution guidelines
   
   Thank you for considering contributing to our project!

   ### Who Can Contribute?
   Only Students: Contributions are limited to individuals currently enrolled as students in the university or institution associated with this project.
    
   ### How to Contribute?
   - Fork the Repository
   - Make Changes: Make your changes or improvements locally.
   - Create a Pull Request: When you are ready to contribute your changes, create a pull request. Please ensure your pull request adheres to the project's guidelines.

   ### Contributors:
   - Giuseppe Valente
   - Natalia Maria Mucha
   - Md Anower Hossain
   - Antonio Ciprani

## Code Ownership:
    
### Exclusive to Students:
While others are encouraged to download, use, and even edit this project, we only accept code contributions from students directly associated with this university project.
    
### Reporting Issues:
If you encounter issues or have suggestions, feel free to open an issue. However, keep in mind that direct code contributions are limited to students.
    
### Note:
By participating in this project, you acknowledge and agree to the contribution guidelines outlined above. Non-student contributors are encouraged to use the project, provide feedback, and suggest improvements through issues.

Thank you for understanding and respecting our contribution policies. We appreciate your interest in our project!

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