<h1 align="center">🌊 Ocean View Resort Reservation System</h1>

<p align="center">
A web-based hotel reservation management system developed using Java, JSP, Servlets, and MySQL.
</p>

<p align="center">
<img src="https://img.shields.io/badge/Java-JDK%2017-orange">
<img src="https://img.shields.io/badge/Server-Tomcat%209-blue">
<img src="https://img.shields.io/badge/Database-MySQL-green">
<img src="https://img.shields.io/badge/Architecture-MVC-yellow">
<img src="https://img.shields.io/badge/Build-Maven-red">
</p>

---

# 📌 Project Overview

The **Ocean View Resort Reservation System** is a web-based application designed to manage hotel room reservations efficiently.

The system allows administrators and staff members to perform reservation management tasks including adding, viewing, updating, and deleting reservations. It also calculates the total bill automatically based on room type and the number of nights.

This project was developed for the **Advanced Programming module** and demonstrates the implementation of **MVC architecture**, **DAO design pattern**, and **Java web technologies**.

---

# ✨ Features

✔ Secure Login System (Admin & Staff)  
✔ Add New Reservations  
✔ View Reservation Details  
✔ Update Reservation Information  
✔ Delete Reservations  
✔ Automatic Bill Calculation  
✔ Staff Management  
✔ Help Section  
✔ Logout Functionality  

---

# 🛠 Technologies Used

| Technology | Purpose |
|------------|--------|
| Java JDK 17 | Core programming language |
| JSP | Frontend page rendering |
| HTML & CSS | User interface design |
| Servlets | Controller logic |
| MySQL | Database management |
| Apache Tomcat 9 | Web server |
| Maven | Project build management |
| Git & GitHub | Version control |

---

# 🏗 System Architecture

The application follows the **MVC (Model View Controller)** architecture.

### Model
Handles business logic and database operations using **DAO classes**.

### View
Implemented using **JSP pages** for user interface.

### Controller
**Servlets** handle HTTP requests and coordinate between View and Model.

### Application Flow




---

# 🗄 Database Structure

Main table used in the system:

### Reservations Table

| Column | Type |
|------|------|
| reservation_id | INT (Primary Key) |
| guest_name | VARCHAR(100) |
| address | VARCHAR(200) |
| contact | VARCHAR(15) |
| email | VARCHAR(100) |
| room_type | VARCHAR(50) |
| nights | INT |
| check_in | DATE |
| check_out | DATE |
| created_at | TIMESTAMP |

---

# 📂 Project Structure



---

# ⚙ Installation Guide

### 1️⃣ Clone the Repository


---

### 2️⃣ Setup Database

Create MySQL database:


---

### 4️⃣ Deploy to Apache Tomcat

1. Build the project using **Maven**
2. Generate **WAR file**
3. Deploy to **Tomcat webapps folder**

Run the application:


---

# 🧪 Testing

The system was tested using **JUnit 5** to verify:

- Reservation operations
- Database interaction
- Business logic

---

# 👨‍💻 Author

**Akila Dissanayake**

Advanced Programming Assignment  
Ocean View Resort Reservation System

GitHub Repository:

https://github.com/akilab30/Ocean-View-Resort

---

# 📄 License

This project is created for **educational purposes**.

