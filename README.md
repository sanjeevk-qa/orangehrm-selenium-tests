# Overview

This repository contains a Selenium automation framework built using Java and TestNG, designed with a strong focus on maintainability, readability, and scalability.

The framework reflects real-world QA automation practices, emphasising clean design, separation of concerns, and configuration-driven execution rather than the number of test scripts.

# Purpose of This Framework

The goal of this framework is to:

- Demonstrate automation engineering fundamentals
- Apply Page Object Model (POM) effectively
- Build a reusable and extensible test structure

This is not intended to be a production framework, but a well-structured learning and demonstration project aligned with enterprise QA practices.

# Tech Stack

**Language:** Java

**Automation Tool:** Selenium WebDriver

**Test Framework:** TestNG

**Build Tool:** Maven

**Design Pattern:** Page Object Model (POM)

**IDE:** IntelliJ IDEA

**Version Control:** Git & GitHub

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

# Test Design Approach

- Tests focus on behaviour validation, not just UI actions
- Assertions are placed meaningfully to validate outcomes
- Tests are kept independent and readable
- Emphasis is placed on stability over volume

# Key Design Considerations

- Page Object Model for maintainability
- Config-driven execution
- Reusable base test setup
- Clean separation of responsibilities
- Readable and debuggable automation code

# Future Enhancements

Some planned improvements include:

- Headless execution support via configuration
- CI/CD integration
- Improved reporting
- Data-driven testing support

# Note

This framework is built as part of continuous learning and skill refinement.
Feedback and suggestions for improvement are always welcome.