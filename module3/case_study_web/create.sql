drop database if exists furama_resort_web;
create database furama_resort_web;
use furama_resort_web;

CREATE TABLE `position` (
    id INT PRIMARY KEY,
    `name` VARCHAR(45)
);
CREATE TABLE education_degree (
    id INT PRIMARY KEY,
    `name` VARCHAR(45)
);
CREATE TABLE division (
    id INT PRIMARY KEY,
    `name` VARCHAR(45)
);
CREATE TABLE `user` (
    username VARCHAR(255) PRIMARY KEY,
    `password` VARCHAR(255)
);
CREATE TABLE employee (
    id INT PRIMARY KEY,
    `name` VARCHAR(45),
    date_of_birth DATE,
    id_card VARCHAR(45),
    salary DOUBLE,
    phone_number VARCHAR(45),
    email VARCHAR(45),
    address VARCHAR(45),
    position_id INT,
    education_degree_id INT,
    division_id INT,
    username VARCHAR(255),
    FOREIGN KEY (position_id)
        REFERENCES `position` (id),
    FOREIGN KEY (education_degree_id)
        REFERENCES education_degree (id),
    FOREIGN KEY (division_id)
        REFERENCES division (id),
    FOREIGN KEY (username)
        REFERENCES `user` (username)
);
CREATE TABLE customer_type (
    id INT PRIMARY KEY,
    `name` VARCHAR(45)
);
CREATE TABLE customer (
    id INT PRIMARY KEY,
    `name` VARCHAR(45),
    day_of_birth DATE,
    gender BIT,
    id_card VARCHAR(45),
    phone_number VARCHAR(45),
    email VARCHAR(45),
    address VARCHAR(45),
    customer_type_id INT,
    FOREIGN KEY (customer_type_id)
        REFERENCES customer_type (id)
);
CREATE TABLE `role` (
    role_id INT PRIMARY KEY,
    role_name VARCHAR(255)
);
CREATE TABLE user_role (
    role_id INT,
    username VARCHAR(255),
    PRIMARY KEY (role_id , username)
);
CREATE TABLE facility_type (
    id INT PRIMARY KEY,
    `name` VARCHAR(45)
);
CREATE TABLE rent_type (
    id INT PRIMARY KEY,
    `name` VARCHAR(45)
);
CREATE TABLE facility (
    id INT PRIMARY KEY,
    `name` VARCHAR(45),
    area INT,
    cost DOUBLE,
    max_people INT,
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area DOUBLE,
    number_of_floors INT,
    facility_free TEXT,
    rent_type_id INT,
    facility_type_id INT,
    FOREIGN KEY (rent_type_id)
        REFERENCES rent_type (id),
    FOREIGN KEY (facility_type_id)
        REFERENCES facility_type (id)
);
CREATE TABLE contract (
    id INT PRIMARY KEY,
    start_date DATETIME,
    end_date DATETIME,
    deposit DOUBLE,
    employee_id INT,
    customer_id INT,
    facility_id INT,
    FOREIGN KEY (employee_id)
        REFERENCES employee (id),
    FOREIGN KEY (customer_id)
        REFERENCES customer (id),
    FOREIGN KEY (facility_id)
        REFERENCES facility (id)
);
CREATE TABLE attach_facility (
    id INT PRIMARY KEY,
    `name` VARCHAR(45),
    cost DOUBLE,
    unit VARCHAR(10),
    `status` VARCHAR(45)
);
CREATE TABLE contract_detail (
    id INT PRIMARY KEY,
    contract_id INT,
    attach_facility_id INT,
    quantity INT,
    FOREIGN KEY (contract_id)
        REFERENCES contract (id),
    FOREIGN KEY (attach_facility_id)
        REFERENCES attach_facility (id)
);

