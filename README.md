# User Registration & Authentication System

A Java-based web application built using Servlets, JSP, JDBC, and PostgreSQL that provides secure user registration and login functionality with session management and password hashing.

## 🚀 Features

- User Registration with server-side validation
- Secure Login Authentication
- Password Hashing using BCrypt
- Duplicate Email Prevention
- Session Management using HttpSession
- Protected Routes using Servlet Filters
- Logout Functionality
- Error Handling & Validation Messages
- JSP + JSTL based dynamic UI

## 🛠 Tech Stack

- Java 8
- Servlets
- JSP / JSTL
- JDBC
- PostgreSQL
- Apache Tomcat 9
- Maven
- HTML / CSS
- Git & GitHub

## 📂 Project Structure

src/main/java/com/project/

- controller → Servlets
- dao → Database operations
- model → Java Beans / Models
- filter → Authentication Filters
- validation → Input validations
- util → Utility classes

src/main/webapp/

- index.jsp
- login.jsp
- dashboard.jsp
- success.jsp

## 🔐 Security Implementations

- BCrypt password hashing with salt
- Session-based authentication
- Protected dashboard access using filters
- Duplicate email account prevention

## 🔄 Application Flow

1. User registers account
2. Password hashed before storing in database
3. User logs in with credentials
4. Session created after successful login
5. Filter protects dashboard page
6. Logout invalidates session

## ⚙️ How to Run

1. Clone repository

```bash
git clone <https://github.com/kartik19230/user-management-system>
```
2. Import project into Eclipse / IntelliJ IDEA

3. Configure PostgreSQL database

4. Update database credentials in the project

5. Run the project on Apache Tomcat Server

## 📈 Future Enhancements

- Forgot Password
- Email Verification
- Role-based Access (Admin/User)
- Spring Boot Migration
- REST API Version

## 👨‍💻 Author

Kartik Shinde

## 🔗 Repository

[View Source Code](https://github.com/kartik19230/user-management-system)

## ⭐ Support

If you found this project useful, consider starring the repository.