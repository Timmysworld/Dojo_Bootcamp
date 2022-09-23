-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Users_cr
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Users_cr` ;

-- -----------------------------------------------------
-- Schema Users_cr
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Users_cr` DEFAULT CHARACTER SET utf8 ;
USE `Users_cr` ;

-- -----------------------------------------------------
-- Table `Users_cr`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Users_cr`.`users` ;

CREATE TABLE IF NOT EXISTS `Users_cr`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NULL,
  `last_name` VARCHAR(255) NULL,
  `email` VARCHAR(255) NULL,
  `created_at` DATETIME NULL DEFAULT 'NOW()',
  `updated_at` DATETIME NULL DEFAULT 'NOW() ON UPDATE NOW()',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
