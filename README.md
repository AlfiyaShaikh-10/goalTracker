# StudyTracker (goalTracker)

A simple REST API built with **Spring Boot** to track study topics/goals — add topics, mark them complete, update, or delete them. This is a classic MVC + layered pattern : Controller → Service → Repository → Database. helps to keep code organized and maintainable.

## Tech Stack

- **Java 17**
- **Spring Boot 3.5.6**
  - Spring Web (REST controllers)
  - Spring Data JPA (database access)
- **MySQL** (database)
- **Lombok** (boilerplate-free getters/setters)
- **Maven** (build tool)

## Project Structure

```
studytracker/
└── src/main/java/com/example/studytracker/
    ├── StudytrackerApplication.java   # main entry point
    ├── config/
    │   └── WebConfig.java             # CORS configuration
    ├── controller/
    │   └── TopicsController.java      # REST API endpoints
    ├── entity/
    │   └── TopicsEntity.java          # JPA entity (maps to `topics` table)
    ├── model/
    │   └── TopicsModel.java           # (reserved for DTOs — currently unused)
    ├── repository/
    │   └── TopicsRepo.java            # Spring Data JPA repository
    └── service/
        └── TopicsService.java         # business logic layer
```

## Features

A "topic" represents a study goal with:
- `id` — auto-generated primary key
- `title` — name of the topic
- `subject` — subject/category it belongs to
- `complete` — whether it's been finished (defaults to `false`)
- `createdAt` — creation timestamp (defaults to current date/time)

## API Endpoints

Base URL: `/api/topics`

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/topics` | Get all topics |
| `GET` | `/api/topics/{id}` | Get a single topic by ID |
| `POST` | `/api/topics` | Create a new topic |
| `PUT` | `/api/topics/{id}` | Update an existing topic (title, subject, complete) |
| `PATCH` | `/api/topics/{id}` | Toggle a topic's `complete` status |
| `DELETE` | `/api/topics/{id}` | Delete a topic |

### Example: Create a topic

```http
POST /api/topics
Content-Type: application/json

{
  "title": "Java Streams",
  "subject": "Java"
}
```

### Example: Toggle completion

```http
PATCH /api/topics/1
Content-Type: application/json

true
```

## Getting Started

### Prerequisites

- Java 17+
- Maven (or use the included `mvnw` wrapper)
- MySQL server running locally

### 1. Set up the database

Create a MySQL database matching the one configured in `application.properties` (default is `test`):

```sql
CREATE DATABASE test;
```

### 2. Configure database credentials

Edit `src/main/resources/application.properties` 

> Table schema is created/updated automatically via `spring.jpa.hibernate.ddl-auto=update` — no manual SQL needed.

### 3. Run the application

Using the Maven wrapper:

```bash
./mvnw spring-boot:run
```

Or on Windows:

```bash
mvnw.cmd spring-boot:run
```

The API will be available at `http://localhost:8080/api/topics`.

## CORS

The API is configured to accept requests from `http://localhost:3000`. Update `WebConfig.java` if your frontend runs on a different origin.


<img width="1881" height="873" alt="image" src="https://github.com/user-attachments/assets/43817ac2-c1be-4dea-9808-69da9fc6e6ed" />
﻿# goalTracker

