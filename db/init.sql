-- Initialize schema and seed data for Ocean View Resort
-- This script is executed automatically by the MySQL container on first startup.

CREATE DATABASE IF NOT EXISTS ocean_view_db;
USE ocean_view_db;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('ADMIN','STAFF') NOT NULL
);

-- Seed users (plain text passwords for demo purposes; consider hashing in production)
INSERT INTO users (username, password, role) VALUES
('admin', 'admin123', 'ADMIN')
ON DUPLICATE KEY UPDATE password=VALUES(password), role=VALUES(role);

INSERT INTO users (username, password, role) VALUES
('staff', 'staff123', 'STAFF')
ON DUPLICATE KEY UPDATE password=VALUES(password), role=VALUES(role);

CREATE TABLE IF NOT EXISTS reservations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    guest_name VARCHAR(100),
    address VARCHAR(200),
    contact VARCHAR(20),
    room_type VARCHAR(20),
    nights INT,
    check_in DATE,
    check_out DATE,
    total_amount DOUBLE
);
