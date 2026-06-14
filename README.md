# API Automation Framework — Restful-Booker

Cucumber BDD automation framework for the [Restful-Booker](https://restful-booker.herokuapp.com/apidoc/index.html) API, built as a final project for API Automation Training.

## Tech Stack
- Java 11+
- Maven
- TestNG
- Cucumber
- RestAssured
- Lombok
- Jackson
- SLF4J (`slf4j-simple`)

## Project Structure

```text
src
 ├── main/java
 │   ├── config
 │   │   └── BaseConfig.java          # Base URL and default headers
 │   ├── dto
 │   │   ├── BookingDto.java           # Request/response DTO with Lombok + Jackson
 │   │   └── ResponseBookingDto.java   # Wrapper for POST /booking response
 │   └── utils
 │       └── TestDataFactory.java      # Factory with unique payload generation (UUID)
 │
 └── test
     ├── java
     │   ├── base
     │   │   ├── BaseTest.java                   # Base test class with shared config
     │   │   └── RequestSpecificationBuilder.java # Shared RequestSpecification builder
     │   ├── runner
     │   │   └── CucumberTestRunner.java          # TestNG-based Cucumber runner
     │   ├── service
     │   │   └── BookingService.java              # API client (POST, GET, PUT, PATCH, DELETE)
     │   └── steps
     │       ├── BookingSteps.java                # Step definitions (thin, delegate to service)
     │       └── Hooks.java                       # @Before/@After hooks, auth token, cleanup
     │
     └── resources
         └── features
             └── Booking.feature                  # BDD scenarios
```

## API Coverage

| Scenario                          | HTTP Methods                        | Tags                  |
|-----------------------------------|-------------------------------------|-----------------------|
| Full E2E flow (create→get→delete) | POST → GET → DELETE → GET (404)     | `@regression @smoke`  |
| Update booking (full payload)     | POST → PUT                          | `@regression`         |
| Update booking (partial payload)  | POST → PATCH                        | `@regression`         |

## Tagging Strategy

| Tag           | Purpose                              | Scenarios |
|---------------|--------------------------------------|-----------|
| `@smoke`      | Quick critical check — API is alive  | 1         |
| `@regression` | Full test suite — all scenarios      | 3         |

## How to Run

Run all tests:
```bash
mvn clean test
```

Run only smoke tests (quick check):
```bash
mvn clean test -Dcucumber.filter.tags="@smoke"
```

Run full regression suite:
```bash
mvn clean test -Dcucumber.filter.tags="@regression"
```

## Reports

After running tests, Cucumber reports are generated at:
- **HTML:** `target/cucumber-reports/cucumber.html`
- **JSON:** `target/cucumber-reports/cucumber.json`

## Design Decisions

- **DTOs with Lombok `@Builder`** — clean payload construction, no raw JSON strings in steps
- **`@JsonInclude(NON_NULL)`** — allows partial PATCH payloads (only set fields are serialized)
- **`TestDataFactory` with UUID** — every run generates unique `firstName`/`lastName` to avoid collisions
- **Service layer (`BookingService`)** — step definitions stay thin and reusable
- **`@Before` hook** — generates auth token before each scenario for authenticated endpoints (PUT, PATCH, DELETE)
- **`@After` hook** — cleanup deletes any created booking so tests are repeatable without manual intervention

