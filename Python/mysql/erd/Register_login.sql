-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Register_login
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Register_login` ;

-- -----------------------------------------------------
-- Schema Register_login
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Register_login` DEFAULT CHARACTER SET utf8 ;
USE `Register_login` ;

-- -----------------------------------------------------
-- Table `Register_login`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Register_login`.`users` ;

CREATE TABLE IF NOT EXISTS `Register_login`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NULL,
  `last_name` VARCHAR(255) NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  `created_at` VARCHAR(255) NULL DEFAULT 'NOW()',
  `updated_at` VARCHAR(255) NULL DEFAULT 'NOW ON UPDATE NOW',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
