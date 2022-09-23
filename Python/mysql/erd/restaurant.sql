-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema restaruant
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `restaruant` ;

-- -----------------------------------------------------
-- Schema restaruant
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `restaruant` DEFAULT CHARACTER SET utf8 ;
USE `restaruant` ;

-- -----------------------------------------------------
-- Table `restaruant`.`restaurants`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `restaruant`.`restaurants` ;

CREATE TABLE IF NOT EXISTS `restaruant`.`restaurants` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `address` VARCHAR(255) NULL,
  `phone_number` VARCHAR(20) NULL,
  `created_at` DATETIME NULL DEFAULT NOW(),
  `updated_at` DATETIME NULL DEFAULT NOW() ON UPDATE NOW(),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaruant`.`menus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `restaruant`.`menus` ;

CREATE TABLE IF NOT EXISTS `restaruant`.`menus` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(255) NULL,
  `created_at` DATETIME NULL DEFAULT NOW(),
  `updated_at` DATETIME NULL DEFAULT NOW() ON UPDATE NOW(),
  `restaurant_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_menus_restaurants_idx` (`restaurant_id` ASC) VISIBLE,
  CONSTRAINT `fk_menus_restaurants`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `restaruant`.`restaurants` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaruant`.`menu_items`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `restaruant`.`menu_items` ;

CREATE TABLE IF NOT EXISTS `restaruant`.`menu_items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `type` VARCHAR(255) NULL,
  `description` VARCHAR(255) NULL,
  `price` INT NULL,
  `created_at` DATETIME NULL DEFAULT NOW(),
  `updated_at` DATETIME NULL DEFAULT NOW() ON UPDATE NOW(),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaruant`.`menu_has_items`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `restaruant`.`menu_has_items` ;

CREATE TABLE IF NOT EXISTS `restaruant`.`menu_has_items` (
  `menu_item_id` INT NOT NULL,
  `menu_id` INT NOT NULL,
  `created_at` DATETIME NULL DEFAULT NOW(),
  `updated_at` DATETIME NULL DEFAULT NOW() ON UPDATE NOW(),
  INDEX `fk_menu_items_has_menus_menus1_idx` (`menu_id` ASC) VISIBLE,
  INDEX `fk_menu_items_has_menus_menu_items1_idx` (`menu_item_id` ASC) VISIBLE,
  CONSTRAINT `fk_menu_items_has_menus_menu_items1`
    FOREIGN KEY (`menu_item_id`)
    REFERENCES `restaruant`.`menu_items` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_menu_items_has_menus_menus1`
    FOREIGN KEY (`menu_id`)
    REFERENCES `restaruant`.`menus` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
