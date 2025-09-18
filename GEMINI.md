# Petstore Clean - Gemini Context

This document provides context for the Gemini AI assistant to understand the Petstore Clean project.

## Project Overview

This project is a sample application demonstrating a "Clean Architecture" approach with Domain-Driven Design (DDD) principles, built using the Spring Boot framework in Java. The application serves as a pet store management system.

The architecture emphasizes a separation of concerns, with a clear distinction between the core domain logic and the infrastructure details. Key technologies include:

*   **Backend:** Java 21, Spring Boot
*   **Frontend:** Thymeleaf with htmx for dynamic UI updates
*   **Database:** PostgreSQL, with migrations managed by Flyway
*   **Build:** Apache Maven
*   **Object Mapping:** MapStruct
*   **Development Environment:** Docker Compose is used to manage the local development environment, including the PostgreSQL database.

## Building and Running
- DO NOT TRY TO RUN
- DO NOT TRY TO BUILD
- DO NOT TRY TO TEST

## Development Conventions

*   **Architecture:** The project follows a use-case-centric approach, with a clean separation between controllers and presenters. This is a core concept of the Clean Architecture.
*   **Database Migrations:** Database schema changes are managed through Flyway. SQL migration scripts are located in `src/main/resources/db/migration`.
*   **Code Style:** The project uses the standard Java conventions. Lombok is used to reduce boilerplate code (e.g., getters, setters, constructors).
*   **Object Mapping:** MapStruct is used for mapping between different object models (e.g., domain models, database entities, and UI view models).
*   **Dependencies:** All dependencies are managed in the `pom.xml` file.

## Architectural rules

* **Rules:** Rules are defined in the Markdown file in [rules](./.copilot/rules) directory.