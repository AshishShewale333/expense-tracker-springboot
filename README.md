
# 💰 Expense Tracker - Spring Boot Backend

This is a backend RESTful API for an Expense Tracker application built using **Spring Boot**. It allows users to manage their expenses by performing CRUD operations and retrieving paginated expense data.

---

## 🚀 Features

- ✅ User registration and login (JWT Authentication)
- ✅ CRUD operations on expenses and categories
- 📊 Pagination and filtering for expense retrieval
- 🔒 Secure REST endpoints using Spring Security
- ☁️ Cloud-deployable (AWS Elastic Beanstalk, RDS-ready)

---

## 🛠️ Tech Stack

- **Java 17**  
- **Spring Boot** (Web, Security, Data JPA)  
- **Spring Security** (JWT authentication)  
- **MySQL** (Amazon RDS)  
- **MapStruct** (DTO ↔ Entity mapping)  
- **Lombok**  
- **AWS Elastic Beanstalk** (deployment)  
- **Maven** (dependency & build management)  

---
## 📦 API Endpoints (Security)


## 🔐 Auth APIs

| Method | Endpoint             | Description       |
|--------|----------------------|-------------------|
| POST   | `/api/auth/register` | Register a user   |
| POST   | `/api/auth/login`    | Login and get JWT |



## 🗂️ Category APIs (Secured)

| Method | Endpoint                  | Description               |
|--------|---------------------------|---------------------------|
| POST   | `/api/v1/categories`      | Create a new category     |
| GET    | `/api/v1/categories`      | Get all categories        |
| DELETE | `/api/v1/categories/{id}` | Delete a category by ID   |



## 💸 Expense APIs (Secured)

| Method | Endpoint                 | Description            |
|--------|--------------------------|------------------------|
| GET    | `/api/v1/expenses`       | Get paginated expenses |
| POST   | `/api/v1/expenses`       | Add a new expense      |
| PUT    | `/api/v1/expenses/{id}`  | Update an expense      |
| DELETE | `/api/v1/expenses/{id}`  | Delete an expense      |



---
## 📦 API Endpoints (Sample)

### 👤 User API

| Method | Endpoint              | Description                     |
|--------|-----------------------|---------------------------------|
| POST   | `/api/v1/users`       | Register a new user             |
| GET    | `/api/v1/users/{id}`  | Get user details by ID          |
| PUT    | `/api/v1/users/{id}`  | Update user info (partial/full) |
| DELETE | `/api/v1/users/{id}`  | Delete user by ID               |



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
### 📂 Category APIs

| Method | Endpoint                      | Description                         |
|--------|-------------------------------|-------------------------------------|
| POST   | `/api/v1/categories`          | Create a new category               |
| GET    | `/api/v1/categories`          | Retrieve a list of all categories   |
| DELETE | `/api/v1/categories/{id}`     | Delete a category by its ID         |

#### 📝 Example Request – Create Category
```http
POST /api/v1/categories
Authorization: Bearer <JWT_TOKEN>
Content-Type: application/json

{
  "name": "Bill",
  "description": "Electricity, Wifi, Mobile",
  "icon": "icon1"
}
```
#### 📥 Example Response – Get All Categories

```json
[
  {
    "id": "c1",
    "name": "Bill",
    "description": "Electricity, Wifi, Mobile",
    "icon": "icon1"
  },
  {
    "id": "c2",
    "name": "Groceries",
    "description": "Food, household items",
    "icon": "icon2"
  }
]

```
#### 📥 Example Request – Delete Category

```http
DELETE /api/v1/categories/c1
Authorization: Bearer <JWT_TOKEN>

```
---
## 💸 Expense APIs

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
## ☁️ AWS Deployment

The backend for this Expense Tracker project is deployed and accessible via AWS Elastic Beanstalk.

🔗 **Live API Endpoint**:  
[`http://expensetrackerbackend-env.eba-3sv2kjt7.eu-north-1.elasticbeanstalk.com/api/v1`](http://expensetrackerbackend-env.eba-3sv2kjt7.eu-north-1.elasticbeanstalk.com/api/v1)

### 🌐 Example Base URLs:

- 👤 Users: `http://expensetrackerbackend-env.eba-3sv2kjt7.eu-north-1.elasticbeanstalk.com/api/v1/users`
- 🔐 Auth: `http://expensetrackerbackend-env.eba-3sv2kjt7.eu-north-1.elasticbeanstalk.com/api/auth/login`
- 📂 Categories: `http://expensetrackerbackend-env.eba-3sv2kjt7.eu-north-1.elasticbeanstalk.com/api/v1/categories`
- 💰 Expenses: `http://expensetrackerbackend-env.eba-3sv2kjt7.eu-north-1.elasticbeanstalk.com/api/v1/expenses`

### ✅ Notes

- Make sure to include the **JWT token** in the `Authorization` header as a Bearer token for all secured endpoints.
- The application is hosted using **AWS Elastic Beanstalk**, configured with MySQL (RDS) and built with Maven.

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


---

## 📬 Postman Collection

To test and explore the Expense Tracker API endpoints easily, you can import the Postman collection provided below.

### 🔗 Collection Link

👉 [Click here to download Postman Collection](https://dev888-3123.postman.co/workspace/Exepense-Tracker~c8ab61a7-e194-487b-9862-f718849dedf4/collection/33963513-97a2e1f6-dca2-4d6b-8ccf-21d02f74a920?action=share&source=copy-link&creator=33963513)  

### 🛠️ How to Use

1. Open **Postman**.
2. Click on **Import** → **Link/File/Raw Text** → Paste or upload the collection.
3. Set your **Base URL** as:  

---

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

