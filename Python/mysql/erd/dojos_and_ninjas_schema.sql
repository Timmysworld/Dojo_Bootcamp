-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dojos_and_ninjas_schema
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `dojos_and_ninjas_schema` ;

-- -----------------------------------------------------
-- Schema dojos_and_ninjas_schema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dojos_and_ninjas_schema` DEFAULT CHARACTER SET utf8 ;
USE `dojos_and_ninjas_schema` ;

-- -----------------------------------------------------
-- Table `dojos_and_ninjas_schema`.`dojo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dojos_and_ninjas_schema`.`dojo` ;

CREATE TABLE IF NOT EXISTS `dojos_and_ninjas_schema`.`dojo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `created_at` DATETIME NULL DEFAULT NOW(),
  `updated_at` DATETIME NULL DEFAULT NOW() ON UPDATE NOW(),
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `dojos_and_ninjas_schema`.`ninjas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dojos_and_ninjas_schema`.`ninjas` ;

CREATE TABLE IF NOT EXISTS `dojos_and_ninjas_schema`.`ninjas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `age` INT NULL DEFAULT NULL,
  `created_at` DATETIME NULL DEFAULT NOW(),
  `updated_at` DATETIME NULL DEFAULT NOW() ON UPDATE NOW(),
  `dojo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ninjas_dojo_idx` (`dojo_id` ASC) VISIBLE,
  CONSTRAINT `fk_ninjas_dojo`
    FOREIGN KEY (`dojo_id`)
    REFERENCES `dojos_and_ninjas_schema`.`dojo` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
