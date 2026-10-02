# Expense Tracker

Java web application for managing personal expenses, with user registration and login.

## Tech Stack
Java, Servlets, JSP, Hibernate ORM, MySQL, HTML, CSS, Bootstrap, Maven

## Features
- User registration and login with HttpSession
- Add, view, update and delete expenses (CRUD)
- DAO architecture with Hibernate and MySQL storage

## How to Run
1. Create a MySQL database for the project
2. Set your MySQL username and password in src/main/java/hibernate.cfg.xml
3. Build with Maven: mvn clean package
4. Deploy the WAR file on Apache Tomcat
5. Open http://localhost:8080/ in your browser
