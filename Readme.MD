# Spring Boot Event Sourcing with Axon Framework

# Run application

* Run axon server

```shell
docker run -d --name axonserver -p 8024:8024 -p 8124:8124 axoniq/axonserver
```

* Run application

```shell
mvn clean spring-boot:run
```

## Test application

* Open [swagger-ui](http://localhost:8080/swagger-ui.html) and use it to verify application
* Open [h2-console](http://localhost:8080/h2-console) and check database entries
* Open [Axon Dashboard](http://localhost:8024) and check event source command and query

## Reference:

* [Implementing Event Sourcing using Axon and Spring Boot](https://progressivecoder.com/implementing-event-sourcing-using-axon-and-spring-boot-part-1/)