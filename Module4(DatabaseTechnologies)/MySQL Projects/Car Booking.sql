CREATE DATABASE car_booking;
DROP DATABASE car_booking;
USE car_booking;

CREATE TABLE Customer
(
  customer_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  customer_name VARCHAR(20) NOT NULL,
  customer_details VARCHAR(200),
  gender CHAR(1),
  email_address VARCHAR(50) CHECK(email_address LIKE '%@%.co%'),
  phone VARCHAR(20) NOT NULL,
  address_line1 VARCHAR(50),
  address_line2 VARCHAR(50),
  address_line3 VARCHAR(50),
  town VARCHAR(50),
  county VARCHAR(50),
  country VARCHAR(50)
);

CREATE TABLE Booking_Status 
(
  booking_status_code VARCHAR(10) PRIMARY KEY,
  booking_status_description VARCHAR(100)
);

CREATE TABLE Manufacturer
( 
  manufacturer_code INT UNSIGNED PRIMARY KEY,
  manufacturer_name VARCHAR(100) NOT NULL,
  manufacturer_details VARCHAR(200)
);

CREATE TABLE Model
(
  model_code VARCHAR(10) PRIMARY KEY,
  daily_hire_date INT UNSIGNED NOT NULL,
  model_name VARCHAR(10) NOT NULL,
  manufacturer_code INT UNSIGNED,
  FOREIGN KEY (manufacturer_code) REfERENCES manufacturer(manufacturer_code)
);

CREATE TABLE Vehicle_Category
(
  vehicle_category_code INT UNSIGNED PRIMARY KEY,
  vehicle_category_description VARCHAR(200) NOT NULL 
);

CREATE TABLE Vehicle
(
  registration_number VARCHAR(10) PRIMARY KEY,
  mileage INT UNSIGNED,
  daily_hire_date INT UNSIGNED,
  date_mot_due DATE,
  engine_size INT UNSIGNED,
  vehicle_category_code INT UNSIGNED,
  model_code VARCHAR(10),
  FOREIGN KEY(vehicle_category_code) REFERENCES vehicle_category(vehicle_category_code),
  FOREIGN KEY(model_code) REFERENCES model(model_code)
);

CREATE TABLE Booking
(
  booking_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  date_from DATE NOT NULL CHECK(date_from > sysdate()),
  date_to DATE NOT NULL,
  confirmation_letter_sent_yn CHAR(1),
  payment_received_yn CHAR(1),
  customer_id INT UNSIGNED,
  booking_status_code VARCHAR(10),
  registration_number VARCHAR(10),
  FOREIGN KEY(registration_number) REFERENCES vehicle (registration_number),
  FOREIGN KEY(booking_status_code) REFERENCES booking_status (booking_status_code),
  FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
  CHECK (date_to > date_from)
);