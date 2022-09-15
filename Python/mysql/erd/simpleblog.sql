-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema simple_blog
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `simple_blog` ;

-- -----------------------------------------------------
-- Schema simple_blog
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `simple_blog` DEFAULT CHARACTER SET utf8 ;
USE `simple_blog` ;

-- -----------------------------------------------------
-- Table `simple_blog`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `simple_blog`.`users` ;

CREATE TABLE IF NOT EXISTS `simple_blog`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `created_at` DATETIME NULL DEFAULT NOW(),
  `updated_at` DATETIME NULL DEFAULT, NOW() ON UPDATE NOW(),
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `simple_blog`.`posts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `simple_blog`.`posts` ;

CREATE TABLE IF NOT EXISTS `simple_blog`.`posts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `posts` TEXT NULL DEFAULT NULL,
  `created_at` DATETIME NULL DEFAULT, NOW()
  `updated_at` DATETIME NULL DEFAULT, NOW() ON UPDATE NOW()
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  INDEX `fk_posts_users_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_posts_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `simple_blog`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `simple_blog`.`comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `simple_blog`.`comments` ;

CREATE TABLE IF NOT EXISTS `simple_blog`.`comments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(255) NULL DEFAULT NULL,
  `created_at` DATETIME NULL DEFAULT NULL,
  `updated_at` DATETIME NULL DEFAULT NULL,
  `user_id` INT NOT NULL,
  `post_id` INT NOT NULL,
  `posts_user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comments_users1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_comments_posts1_idx` (`post_id` ASC, `posts_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_comments_posts1`
    FOREIGN KEY (`post_id` , `posts_user_id`)
    REFERENCES `simple_blog`.`posts` (`id` , `user_id`),
  CONSTRAINT `fk_comments_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `simple_blog`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
