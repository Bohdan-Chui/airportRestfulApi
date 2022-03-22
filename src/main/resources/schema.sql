-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema airport
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema airport
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `airport` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `airport` ;

-- -----------------------------------------------------
-- Table `airport`.`air_company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airport`.`air_company` (
                                                       `id` INT NOT NULL AUTO_INCREMENT,
                                                       `company_type` VARCHAR(255) NULL DEFAULT NULL,
                                                       `founded_date` DATE NULL DEFAULT NULL,
                                                       `name` VARCHAR(255) NULL DEFAULT NULL,
                                                       PRIMARY KEY (`id`),
                                                       UNIQUE INDEX `UK_8dtowp4c00cgujvdnj9mhab82` (`name` ASC) VISIBLE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `airport`.`airplane`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airport`.`airplane` (
                                                    `id` INT NOT NULL AUTO_INCREMENT,
                                                    `created_date` DATE NULL DEFAULT NULL,
                                                    `factory_serial_number` VARCHAR(255) NULL DEFAULT NULL,
                                                    `flight_distance` INT NULL DEFAULT NULL,
                                                    `fuel_capacity` INT NULL DEFAULT NULL,
                                                    `name` VARCHAR(255) NULL DEFAULT NULL,
                                                    `number_flights` INT NULL DEFAULT NULL,
                                                    `type` VARCHAR(255) NULL DEFAULT NULL,
                                                    `air_company_id` INT NULL DEFAULT NULL,
                                                    PRIMARY KEY (`id`),
                                                    INDEX `FKp9yob98tmyb901cnu35k9uy43` (`air_company_id` ASC) VISIBLE,
                                                    CONSTRAINT `FKp9yob98tmyb901cnu35k9uy43`
                                                        FOREIGN KEY (`air_company_id`)
                                                            REFERENCES `airport`.`air_company` (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `airport`.`flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airport`.`flight` (
                                                  `id` INT NOT NULL AUTO_INCREMENT,
                                                  `created_date` DATETIME NULL DEFAULT NULL,
                                                  `delay_started_at` DATETIME NULL DEFAULT NULL,
                                                  `departure_country` VARCHAR(255) NULL DEFAULT NULL,
                                                  `destination_country` VARCHAR(255) NULL DEFAULT NULL,
                                                  `distance` DOUBLE NULL DEFAULT NULL,
                                                  `ended_time` DATETIME NULL DEFAULT NULL,
                                                  `estimated_flight_time` BIGINT NULL DEFAULT NULL,
                                                  `flight_status` VARCHAR(255) NULL DEFAULT NULL,
                                                  `started_time` DATETIME NULL DEFAULT NULL,
                                                  `air_company_id` INT NULL DEFAULT NULL,
                                                  `airplane_id` INT NULL DEFAULT NULL,
                                                  PRIMARY KEY (`id`),
                                                  INDEX `FKebvst1vfvhmhgn73mqs1vt8m7` (`air_company_id` ASC) VISIBLE,
                                                  INDEX `FKb8t4272gfgo1feyyidvscbjm0` (`airplane_id` ASC) VISIBLE,
                                                  CONSTRAINT `FKb8t4272gfgo1feyyidvscbjm0`
                                                      FOREIGN KEY (`airplane_id`)
                                                          REFERENCES `airport`.`airplane` (`id`),
                                                  CONSTRAINT `FKebvst1vfvhmhgn73mqs1vt8m7`
                                                      FOREIGN KEY (`air_company_id`)
                                                          REFERENCES `airport`.`air_company` (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;