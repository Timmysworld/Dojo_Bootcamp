-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema friendship_schema
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `friendship_schema` ;

-- -----------------------------------------------------
-- Schema friendship_schema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `friendship_schema` DEFAULT CHARACTER SET utf8 ;
USE `friendship_schema` ;

-- -----------------------------------------------------
-- Table `friendship_schema`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `friendship_schema`.`users` ;

CREATE TABLE IF NOT EXISTS `friendship_schema`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `created_at` DATETIME NULL DEFAULT NOW(),
  `updated_at` DATETIME NULL DEFAULT NOW() ON UPDATE NOW(),
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `friendship_schema`.`friendships`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `friendship_schema`.`friendships` ;

CREATE TABLE IF NOT EXISTS `friendship_schema`.`friendships` (
  `user_id` INT NOT NULL,
  `friend_id` INT NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME NULL DEFAULT NOW(),
  `updated_at` DATETIME NULL DEFAULT NOW() ON UPDATE NOW(),
  PRIMARY KEY (`id`),
  INDEX `fk_users_has_users_users1_idx` (`friend_id` ASC) VISIBLE,
  INDEX `fk_users_has_users_users_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_users_has_users_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `friendship_schema`.`users` (`id`),
  CONSTRAINT `fk_users_has_users_users1`
    FOREIGN KEY (`friend_id`)
    REFERENCES `friendship_schema`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
