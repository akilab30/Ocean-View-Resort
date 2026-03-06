
CREATE DATABASE oceanview;
USE oceanview;

CREATE TABLE users(
id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(50),
password VARCHAR(100),
role VARCHAR(20)
);

INSERT INTO users(username,password,role) VALUES('admin','admin','admin');

CREATE TABLE reservations(
reservation_id INT AUTO_INCREMENT PRIMARY KEY,
guest_name VARCHAR(100),
address VARCHAR(200),
contact VARCHAR(15),
email VARCHAR(100),
room_type VARCHAR(50),
nights INT,
check_in DATE,
check_out DATE,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE staff(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100),
role VARCHAR(100),
contact VARCHAR(20),
email VARCHAR(100)
);
