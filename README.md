# Overview

This repository contains a Selenium automation framework built using Java and TestNG, designed with a strong focus on maintainability, readability, and scalability.

The framework reflects real-world QA automation practices, emphasising clean design, separation of concerns, and configuration-driven execution rather than the number of test scripts.

It also includes basic execution reporting and logging to aid debugging and result analysis.

# Purpose of This Framework

The goal of this framework is to:

- Demonstrate automation engineering fundamentals
- Apply Page Object Model (POM) effectively
- Build a reusable and extensible test structure

This is not intended to be a production framework, but a well-structured learning and demonstration project aligned with enterprise QA practices.

The framework is intentionally kept lightweight to mirror how automation typically evolves incrementally in real QA teams.

# Tech Stack

**Language:** Java

**Automation Tool:** Selenium WebDriver

**Test Framework:** TestNG

**Build Tool:** Maven

**Design Pattern:** Page Object Model (POM)

**IDE:** IntelliJ IDEA

**Version Control:** Git & GitHub

**Reporting:** Extent Reports

**Logging:** SLF4J / Logback

# Project Structure
``` text
src
├── main
│   ├── java
│   │   ├── base        → Base test setup and teardown
│   │   ├── factory    → Browser initialization logic
│   │   ├── config     → Configuration readers
│   │   └── utils      → Utility and helper classes
│
├── test
│   ├── java
│   │   ├── pages      → Page Object classes
│   │   └── tests      → Test classes
│
├── resources
│   └── config.properties
```

This structure ensures:

- Clear separation between test logic and page behaviour
- Centralised configuration management
- Easy scalability as test coverage grows

# Configuration Management

All environment-specific values such as:

- Application URL
- Browser selection

are managed through a `config.properties` file.

This avoids hard-coded values and makes the framework flexible and easy to extend.

# How to Run the Tests

## Prerequisites
- Java installed (JDK 8 or above)
- Maven installed
- Chrome browser (or supported browser)

## Run via Maven 
``` bash
mvn clean test
```

## Run via IDE

- Import the project into IntelliJ IDEA
- Run TestNG test classes directly

## Reporting and Logging
-Extent Reports are used to generate HTML execution reports, providing visibility into:
Passed and failed test cases
Execution flow
Failure details
-Logging is implemented using SLF4J and Logback to capture key test actions and aid debugging during failures.
-Reports and logs help analyse failures more effectively, especially during regression runs.

# Test Design Approach

- Tests focus on behaviour validation, not just UI actions
- Assertions are placed meaningfully to validate outcomes
- Tests are kept independent and readable
- Emphasis is placed on stability over volume
- Automation is treated as a quality support mechanism rather than an attempt to automate every scenario.

# Key Design Considerations

- Page Object Model for maintainability
- Config-driven execution
- Reusable base test setup
- Clean separation of responsibilities
- Readable and debuggable automation code
- -Framework design prioritises clarity and maintainability over complexity.

# Future Enhancements

Some planned improvements include:

- Headless execution support via configuration
- CI/CD integration
- Improved reporting
- Data-driven testing support
- Additional enhancements may be added incrementally as part of continuous learning.

# Note

This framework is built as part of continuous learning and skill refinement.
Feedback and suggestions for improvement are always welcome.

The repository is intentionally maintained as a living project rather than a one-time showcase.