# Java Inventory Management System

A simple inventory management system built using Java, JDBC, and MySQL.

## Features
- Add new products to the inventory
- View all products in the inventory
- Update product details (name, quantity, price)
- Delete products from the inventory

## Technologies Used
- Java
- JDBC
- MySQL

## Setup Instructions

1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/Java-Inventory-Management.git
   ```

2. Install MySQL and create the database:
   ```sql
   CREATE DATABASE InventoryDB;
   USE InventoryDB;
   CREATE TABLE Products (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100),
       quantity INT,
       price DECIMAL(10, 2)
   );
   ```

3. Configure the database connection:
   - Edit the `config/db_config.properties` file with your database details:
     ```properties
     db.url=jdbc:mysql://localhost:3306/InventoryDB
     db.username=root
     db.password=yourpassword
     ```

4. Compile and run the project:
   - If using Gradle:
     ```bash
     gradle run
     ```

## Screenshots
(Optional) Add screenshots of the project in action.

## Future Enhancements
- User authentication
- Reporting features
- Web interface (Spring Boot)
