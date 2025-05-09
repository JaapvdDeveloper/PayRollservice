
# PayRoll Service API

A RESTful API for managing employee payroll data built with Spring Boot, based on the [Spring REST tutorial](https://spring.io/guides/tutorials/rest).

## 🔍 Overview

This project implements a payroll management system with RESTful APIs to perform CRUD operations on employee records and order processing. It demonstrates Spring Boot best practices and incorporates HATEOAS (Hypermedia as the Engine of Application State) principles.

## ✨ Features

- Complete CRUD operations for employee management
- Order processing with status tracking
- HATEOAS implementation with navigable API links
- Exception handling with appropriate HTTP status codes
- Content negotiation

## 🚀 Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6+ or Gradle 7.0+
- Git

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/PayRollservice.git
   cd PayRollservice
   ```

2. Build the project:
   ```
   ./mvnw clean install
   ```

3. Run the application:
   ```
   ./mvnw spring-boot:run
   ```

The server will start at `http://localhost:8080`.

## 📚 API Documentation

### Employees

| HTTP Method | Endpoint | Description |
|-------------|----------|-------------|
| GET | `/employees` | Retrieve all employees |
| GET | `/employees/{id}` | Retrieve a specific employee |
| POST | `/employees` | Create a new employee |
| PUT | `/employees/{id}` | Update an existing employee |
| DELETE | `/employees/{id}` | Delete an employee |

### Orders

| HTTP Method | Endpoint | Description |
|-------------|----------|-------------|
| GET | `/orders` | Retrieve all orders |
| GET | `/orders/{id}` | Retrieve a specific order |
| POST | `/orders` | Create a new order |
| PUT | `/orders/{id}/complete` | Mark an order as completed |
| DELETE | `/orders/{id}/cancel` | Cancel an order |

## 💻 Examples

### Get all employees

```bash
curl -v localhost:8080/employees
```

### Create a new employee

```bash
curl -v -X POST localhost:8080/employees \
  -H "Content-Type: application/json" \
  -d '{"name": "John Doe", "role": "Developer"}'
```

### Update an employee

```bash
curl -v -X PUT localhost:8080/employees/1 \
  -H "Content-Type: application/json" \
  -d '{"name": "John Doe", "role": "Senior Developer"}'
```

### Delete an employee

```bash
curl -v -X DELETE localhost:8080/employees/1
```

### Create a new order

```bash
curl -v -X POST localhost:8080/orders \
  -H "Content-Type: application/json" \
  -d '{"description": "MacBook Pro", "status": "IN_PROGRESS"}'
```

## 🔗 HATEOAS Links

This API implements HATEOAS, providing navigable links in API responses. Example response:

```json
{
  "id": 1,
  "name": "Bilbo Baggins",
  "role": "burglar",
  "_links": {
    "self": {
      "href": "http://localhost:8080/employees/1"
    },
    "employees": {
      "href": "http://localhost:8080/employees"
    }
  }
}
```



## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.
