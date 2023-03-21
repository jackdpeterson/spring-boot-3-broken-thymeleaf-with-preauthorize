# spring-boot-3-broken-thymeleaf-with-preauthorize

## Overall concepts:
1. Flyway creates DB table (docker-compose up to spin up mysql DB)
2. Migrate from Spring 2.7.4 via the latest commit which modifies the pom.xml.
2.a. connect to http://localhost:8080 (username: user, password: password).
3. Observe broken on Spring boot 3.0.


## What I've tested so far:
WebMVC + JDBC on 2.7.x works fine
WebFlux + R2dbc on 2.7.x works fine
WebFlux + R2dbc on 3.0.x does not work.
