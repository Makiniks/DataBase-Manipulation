CREATE DATABASE `dados`;
USE `dados`;
CREATE TABLE `nichos` (
	`ID` INT(11) NOT NULL AUTO_INCREMENT,
	`Nicho` VARCHAR(40) NOT NULL,
	PRIMARY KEY (`ID`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;
CREATE TABLE `clientes` (
	`ID` INT(3) NOT NULL AUTO_INCREMENT,
	`Nicho` INT(2) NOT NULL,
	`Status` BIT(1) NOT NULL,
	`Nome` VARCHAR(40) NOT NULL,
	`Email` VARCHAR(40) NOT NULL,
	PRIMARY KEY (`ID`),
	INDEX `FK_cliente_nichos` (`Nicho`),
	CONSTRAINT `FK_cliente_nichos` FOREIGN KEY (`Nicho`) REFERENCES `nichos` (`ID`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;