# Todolist API

API for task management, developed as part of the **Simplify backend challenge**. It allows creating, updating, listing, and deleting tasks. The challenge details can be found [here](https://github.com/simplify-tec/desafio-junior-backend-simplify).

## Technologies Used

- Java
- Spring Boot
- Maven
- PostgreSQL
- Swagger/OpenAPI

## Environment Setup

### Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher
- PostgreSQL

### Database Configuration

- Update the connection settings in the `src/main/resources/application.properties` file:

```ini
spring.datasource.url=jdbc:postgresql://localhost:5432/todolist-challenge-backend-simplify
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

### Running the Application

1. Clone the repository:

```bash
git clone https://github.com/hamiltongomes/todolist-challenge-backend-simplify.git
```

2. Navigate to the project directory:

```bash
cd todolist-challenge-backend-simplify
```

3. Compile and run the application:

```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`.

## API Documentation

The API documentation is available at `http://localhost:8080/swagger-ui.html`.

## Endpoints

### Create Task

- **URL:** `/task`
- **Method:** `POST`
- **Request Body:**

```json
{
  "name": "Task Name",
  "description": "Task Description",
  "isRealized": false,
  "taskPriority": "HIGH"
}
```

- **Response:**

```json
{
  "id": 1,
  "name": "Task Name",
  "description": "Task Description",
  "isRealized": false,
  "taskPriority": "HIGH"
}
```

### Update Task

- **URL:** `/task/{id}`
- **Method:** `PUT`
- **Request Body:**

```json
{
  "name": "Updated Task Name",
  "description": "Updated Task Description",
  "isRealized": true,
  "taskPriority": "LOW"
}
```

- **Response:**

```json
{
  "id": 1,
  "name": "Updated Task Name",
  "description": "Updated Task Description",
  "isRealized": true,
  "taskPriority": "LOW"
}
```

### Get Task by ID

- **URL:** `/task/{id}`
- **Method:** `GET`
- **Response:**

```json
{
  "id": 1,
  "name": "Task Name",
  "description": "Task Description",
  "isRealized": false,
  "taskPriority": "HIGH"
}
```

### Get All Tasks

- **URL:** `/task`
- **Method:** `GET`
- **Response:**

```json
[
  {
    "id": 1,
    "name": "Task Name",
    "description": "Task Description",
    "isRealized": false,
    "taskPriority": "HIGH"
  }
]
```

### Get Tasks by Realized Status

- **URL:** `/task/realized`
- **Method:** `GET`
- **Parameters:**

```json
{
  "realizedStatus": true
}
```

- **Response:**

```json
[
  {
    "id": 1,
    "name": "Task Name",
    "description": "Task Description",
    "isRealized": true,
    "taskPriority": "HIGH"
  }
]
```

### Get Tasks by Active Status

- **URL:** `/task/active`
- **Method:** `GET`
- **Parameters:**

```json
{
  "activeStatus": true
}
```

- **Response:**

```json
[
  {
    "id": 1,
    "name": "Task Name",
    "description": "Task Description",
    "isRealized": false,
    "taskPriority": "HIGH"
  }
]
```

### Disable Task

- **URL:** `/task/{id}`
- **Method:** `DELETE`
- **Response:** `204 No Content`

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
