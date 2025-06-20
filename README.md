# expense-tracker-springboot


# 💰 Expense Tracker - Spring Boot Backend

This is a backend RESTful API for an Expense Tracker application built using **Spring Boot**. It allows users to manage their expenses by performing CRUD operations and retrieving paginated expense data.

---

## 🚀 Features

- ✅ Create, Read, Update, Delete (CRUD) expenses
- 📊 Pagination support for expense listing
- 🧩 Clean REST API design
- 🔒 CORS-configurable and ready for frontend integration

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **MySQL / H2 (Configurable)**
- **Lombok**

---

## 📦 API Endpoints (Sample)

| Method | Endpoint                 | Description            |
|--------|--------------------------|------------------------|
| GET    | `/api/v1/expenses`       | Get paginated expenses |
| POST   | `/api/v1/expenses`       | Add a new expense      |
| PUT    | `/api/v1/expenses/{id}`  | Update an expense      |
| DELETE | `/api/v1/expenses/{id}`  | Delete an expense      |

Pagination Example:
```http
GET /api/v1/expenses?page=0&size=5
``` 

---
##🧑‍💻 Getting Started
Prerequisites
Java 17+

Maven

MySQL (or use embedded H2)

Setup
Clone the repository:

bash

git clone https://github.com/AshishShewale333/expense-tracker-springboot.git
cd expense-tracker-springboot
Configure application.properties:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_db
spring.datasource.username=your_username
spring.datasource.password=your_password
Run the app:

bash
./mvnw spring-boot:run
🧪 Testing the API
You can test the endpoints using:

Postman

Swagger (if configured)

Curl / HTTPie

📁 Folder Structure
css
Copy
Edit
src/
├── main/
│   ├── java/
│   │   └── com.example.expensetracker/
│   │       ├── controller/
│   │       ├── service/
│   │       ├── repository/
│   │       └── model/
│   └── resources/
│       └── application.properties
🙋‍♂️ Author
Ashish Shewale
GitHub: @AshishShewale333
