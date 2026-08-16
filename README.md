# Spring Boot RESTful API Service

A production-ready RESTful API backend built with **Spring Boot**, **Spring Security (JWT)**, **Spring Data JPA**, and **Flyway Migration**. This project features stateless authentication, server-side pagination & sorting, standardized response wrappers, and OpenAPI/Swagger documentation.

---

## 🛠️ Tech Stack

- **Language:** Java 17+
- **Framework:** Spring Boot 4.x
- **Security:** Spring Security & JJWT (JSON Web Token)
- **Database:** MySQL
- **Migration:** Flyway Migration
- **Persistence:** Spring Data JPA / Hibernate
- **Documentation:** OpenAPI 3 / Swagger UI
- **Build Tool:** Maven

---

## 🚀 Key Features

* **Authentication & Authorization**: Stateless user registration and login flow using JWT Bearer Tokens.
* **Database Version Control**: Automated database schema management via Flyway scripts.
* **Pagination & Sorting**: Efficient querying for large datasets using Spring Data `Pageable`.
* **Standardized API Response**: Uniform JSON response structure using a custom `ApiResponse<T>` wrapper.
* **Interactive API Docs**: Fully interactive endpoint documentation powered by Swagger UI.

---

## ⚙️ Getting Started

### 1. Prerequisites
- Java JDK 17 or higher
- MySQL Server
- Maven

### 2. Database Configuration
Create a new MySQL database:
CREATE DATABASE your_database_name;

Update your database credentials in src/main/resources/application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name?createDatabaseIfNotExist=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=none

### 3. Running the Application
Execute the application via your IDE or terminal:
mvn spring-boot:run

📌 API Documentation (Swagger UI)
Access the interactive API documentation at:
http://localhost:8080/swagger-ui.html

### Key Endpoints Overview

| Method | Endpoint | Access | Description |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/v1/auth/register` | Public | Register a new user account |
| `POST` | `/api/v1/auth/login` | Public | Authenticate user & return JWT token |
| `GET` | `/api/v1/packages` | Authenticated | Retrieve paginated & sorted package list |
| `POST` | `/api/v1/packages` | Authenticated | Create a new package |
| `GET` | `/api/v1/packages/{id}` | Authenticated | Get package details by ID |
| `PUT` | `/api/v1/packages/{id}` | Authenticated | Update package details by ID |
| `DELETE` | `/api/v1/packages/{id}` | Authenticated | Delete package by ID |
| `GET` | `/api/v1/packages/search` | Authenticated | Search packages by name/keyword |
| `GET` | `/api/v1/packages/filter-price` | Authenticated | Filter packages by price range |
