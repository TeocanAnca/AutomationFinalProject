# API Automation Training Framework

Beginner-friendly API automation framework for manual QAs learning Java API testing with the Swagger Petstore API.

## Tech stack
- Java 11+
- Maven
- TestNG
- RestAssured
- Lombok
- Jackson
- SLF4J (`slf4j-simple` in tests)

## Project structure

```text
src
 ├── main
 │   └── java
 │       ├── config
 │       │   └── BaseConfig.java
 │       ├── dto
 │       │   └── PetDto.java
 │       └── utils
 │           └── TestDataFactory.java
 │
 └── test
     └── java
         ├── base
         │   └── BaseTest.java
         └── tests
             └── PetApiTests.java
```

## What is covered
- API framework structure
- RestAssured request building (`given / when / then`)
- CRUD flow with `POST`, `GET`, `PUT`, `DELETE`
- Common headers and simple API key usage
- DTOs for JSON mapping
- Serialization and deserialization with Jackson

## Run tests

```bash
mvn clean test
```

## Notes for trainees
- Each test creates its own pet id, so tests can run repeatedly without conflicts.
- `PetDto` keeps tests readable compared to hardcoded JSON strings.
- `TestDataFactory` centralizes object creation so test data is easy to update.
- Test logs now go through SLF4J instead of `System.out.println`, so output stays consistent across runs.

