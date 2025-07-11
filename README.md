# Spring Boot REST CRUD - Employee API

A simple Spring Boot REST API for managing employees.

This project demonstrates basic CRUD operations (`GET`, `POST`, `PUT`, `PATCH`, `DELETE`) using:

- ✅ Spring Boot  
- ✅ Spring Data JPA (with Hibernate)  
- ✅ MySQL  
- ✅ Jackson `ObjectMapper` for partial updates (`PATCH`)  
- ✅ Exception handling with `@ControllerAdvice`

---

##  Features

- Full CRUD operations on employee records  
- Partial update support using HTTP `PATCH` and Jackson `ObjectMapper`  
- Centralized error handling with `@ControllerAdvice`  
- Clean layered architecture:  
  **Controller → Service → DAO → Database**

---

##  Technologies Used

- Java 17+  
- Spring Boot 3.x  
- Maven  
- MySQL  
- Postman (for API testing)

---

##  Database Setup (MySQL)

Run the following SQL script to create and populate the `employee_directory` database:

```sql
CREATE DATABASE IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

-- Table structure for table `employee`
DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Sample data
INSERT INTO `employee` VALUES 
  (1, 'Leslie', 'Andrews', 'leslie@luv2code.com'),
  (2, 'Emma', 'Baumgarten', 'emma@luv2code.com'),
  (3, 'Avani', 'Gupta', 'avani@luv2code.com'),
  (4, 'Yuri', 'Petrov', 'yuri@luv2code.com'),
  (5, 'Juan', 'Vega', 'juan@luv2code.com');
