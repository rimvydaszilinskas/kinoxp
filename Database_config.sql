SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS customers;
CREATE TABLE customers(
  id INT(5) NOT NULL PRIMARY KEY auto_increment,
  name VARCHAR(45) NOT NULL
);

DROP TABLE IF EXISTS genres;
CREATE TABLE genres(
  id INT(5) NOT NULL auto_increment primary key,
  name VARCHAR(45) NOT NULL
);

DROP TABLE IF EXISTS movies;
CREATE TABLE movies(
  id INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  genre INT(5) NOT NULL,
  age_limit INT(2) NOT NULL,
  FOREIGN KEY movies(genre) REFERENCES genres(id)
);

DROP TABLE IF EXISTS seats;
CREATE TABLE seats(
  id INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  space VARCHAR(5) NOT NULL, #1.1, 1.2 ...
  room INT(1) NOT NULL,
  booked INT(1) NOT NULL
);

DROP TABLE IF EXISTS reservations;
CREATE TABLE reservations(
  id INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  movie_id INT(5) NOT NULL,
  seat_id INT(5) NOT NULL,
  date DATE NOT NULL,
  time INT(4) NOT NULL,
  customer_id INT(5) NOT NULL,
  FOREIGN KEY reservations1(movie_id) REFERENCES movies(id),
  FOREIGN KEY reservations2(customer_id) REFERENCES customers(id),
  FOREIGN KEY reservations3(seat_id) REFERENCES seats(id)
);

DROP TABLE IF EXISTS employees;
CREATE TABLE employees(
  id INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  username VARCHAR(45) NOT NULL,
  password VARCHAR(255) NOT NULL UNIQUE
);
