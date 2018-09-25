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

DROP TABLE IF EXISTS movie;
CREATE TABLE movie(
	id INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    genre INT(5) NOT NULL,
    age_limit INT(2) NOT NULL,
    FOREIGN KEY movie(genre) REFERENCES genres(id)
);

DROP TABLE IF EXISTS reservation;
CReATE TABLE reservation(
	id INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    reservation_id INT(5) NOT NULL,
    seat_number INT(5) NOT NULL,
    date DATE NOT NULL, 
    time varchar(5),
    customer VARCHAR(45) NOT NULL,
    FOREIGN KEY reservation(reservation_id) REFERENCES movie(id)
);