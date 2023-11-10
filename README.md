spring-project
--------------
Technologies Used
-----------------
Spring Boot
Spring JDBC
MySQL
Maven

Prerequisites
------------
Before running the application, make sure you have the following installed:

Java Development Kit (JDK) 8 or later
Maven
MySQL

Configuration
-------------
Open the application.properties file in the src/main/resources directory.
Configure the MySQL database connection properties:

spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password

Model
-----
Book
id (int): The unique identifier for the book.
title (String): The title of the book.
author (String): The author of the book.
price (double): The price of the book.
amount (int): The quantity of books available.
