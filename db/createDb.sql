-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hotelbooking
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hotelbooking
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotelbooking` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `hotelbooking` ;

-- -----------------------------------------------------
-- Table `hotelbooking`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelbooking`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `password` VARCHAR(128) NOT NULL,
  `balance` DECIMAL(9,2) NULL DEFAULT '0.00',
  `role` ENUM('admin', 'user') NULL DEFAULT 'user',
  `blocking_status` ENUM('blocked', 'unblocked') NULL DEFAULT 'unblocked',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hotelbooking`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelbooking`.`room` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `room_number` VARCHAR(10) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `is_deleted` TINYINT(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 29
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hotelbooking`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelbooking`.`order` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_client` INT(11) NOT NULL,
  `check_in_date` DATE NOT NULL,
  `check_out_date` DATE NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `id_room` INT(11) NULL DEFAULT NULL,
  `cost` DECIMAL(9,2) NULL DEFAULT NULL,
  `invoice_date` DATE NULL DEFAULT NULL,
  `payment_status` ENUM('paid', 'unpaid') NOT NULL DEFAULT 'unpaid',
  `order_status` ENUM('inprocess', 'seen', 'completed', 'canceled') NOT NULL DEFAULT 'inprocess',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_order_UNIQUE` (`id` ASC),
  INDEX `id_room_idx` (`id_room` ASC),
  INDEX `id_client_order_idx` (`id_client` ASC),
  INDEX `id_room_order_idx` (`id_room` ASC),
  CONSTRAINT `id_client_order`
    FOREIGN KEY (`id_client`)
    REFERENCES `hotelbooking`.`user` (`id`),
  CONSTRAINT `id_room_order`
    FOREIGN KEY (`id_room`)
    REFERENCES `hotelbooking`.`room` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hotelbooking`.`room_busy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelbooking`.`room_busy` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_room` INT(11) NOT NULL,
  `date_start` DATE NOT NULL,
  `date_end` DATE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `roomId_idx` (`id_room` ASC),
  CONSTRAINT `roomId`
    FOREIGN KEY (`id_room`)
    REFERENCES `hotelbooking`.`room` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hotelbooking`.`room_price`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelbooking`.`room_price` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_room` INT(11) NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `cost` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_room_idx` (`id_room` ASC),
  CONSTRAINT `id_room`
    FOREIGN KEY (`id_room`)
    REFERENCES `hotelbooking`.`room` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 41
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hotelbooking`.`transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelbooking`.`transaction` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_client` INT(11) NOT NULL,
  `operation` ENUM('moneytransfer', 'paymentforservices') NOT NULL,
  `date` DATE NOT NULL,
  `sum` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_client_transaction_idx` (`id_client` ASC),
  CONSTRAINT `id_client_transaction`
    FOREIGN KEY (`id_client`)
    REFERENCES `hotelbooking`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 33
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
