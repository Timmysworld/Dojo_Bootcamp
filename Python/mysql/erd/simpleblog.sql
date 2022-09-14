-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema simple_blog
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema simple_blog
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `simple_blog` DEFAULT CHARACTER SET utf8 ;
USE `simple_blog` ;

-- -----------------------------------------------------
-- Table `simple_blog`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simple_blog`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `simple_blog`.`posts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simple_blog`.`posts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `posts` TEXT NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  INDEX `fk_posts_users_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_posts_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `simple_blog`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `simple_blog`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simple_blog`.`comments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(255) NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  `user_id` INT NOT NULL,
  `post_id` INT NOT NULL,
  `posts_user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comments_users1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_comments_posts1_idx` (`post_id` ASC, `posts_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_comments_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `simple_blog`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_posts1`
    FOREIGN KEY (`post_id` , `posts_user_id`)
    REFERENCES `simple_blog`.`posts` (`id` , `user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
