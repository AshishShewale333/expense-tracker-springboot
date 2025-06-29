
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

### 👤 User API

| Method | Endpoint              | Description                     |
|--------|-----------------------|---------------------------------|
| POST   | `/api/v1/users`       | Register a new user             |
| GET    | `/api/v1/users/{id}`  | Get user details by ID          |
| PUT    | `/api/v1/users/{id}`  | Update user info (partial/full) |
| DELETE | `/api/v1/users/{id}`  | Delete user by ID               |

---

#### 📝 Example Request – Create User

```http
POST /api/v1/users
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "securePass123",
  "age": 30
}
```
#### 🔄 Example Request – Update User

```http
PUT /api/v1/users/1
Content-Type: application/json

{
  "name": "John Updated",
  "email": "john.updated@example.com",
  "password": "newSecurePass456",
  "age": 31
}

```
#### 📥 Example Response – Get User

```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "age": 30
}

```

---
## 🧑‍💻 Getting Started

### ✅ Prerequisites

- Java 17+
- Maven
- MySQL (or use embedded H2)

---

### ⚙️ Setup

1. **Clone the repository:**

```bash
git clone https://github.com/AshishShewale333/expense-tracker-springboot.git
cd expense-tracker-springboot


```

### 🔧2. Configure `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### ▶️ 3. Run the App

If you're using the provided Maven wrapper:

```bash
./mvnw spring-boot:run
```

✅ Or, if Maven is installed on your system:

```bash
mvn spring-boot:run

```


Postman


📁 **Folder Structure**
```bash
src/
├── main/
│ ├── java/
│ │ └── com.example.expensetracker/
│ │ ├── controller/
│ │ ├── service/
│ │ ├── repository/
│ │ └── model/
│ └── resources/
│ └── application.properties
```


---

🙋‍♂️ **Author**

Ashish Shewale  
GitHub: [@AshishShewale333](https://github.com/AshishShewale333)

