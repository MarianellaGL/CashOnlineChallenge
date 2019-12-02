-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: challengecashonline1
-- Source Schemata: challengecashonline
-- Created: Sun Dec  1 21:03:57 2019
-- Workbench Version: 8.0.17
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema challengecashonline1
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `challengecashonline1` ;
CREATE SCHEMA IF NOT EXISTS `challengecashonline1` ;

-- ----------------------------------------------------------------------------
-- Table challengecashonline1.prestamo
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `challengecashonline1`.`prestamo` (
  `prestamo_id` INT(11) NOT NULL AUTO_INCREMENT,
  `monto_prestamo` VARCHAR(45) NOT NULL,
  `cant_cuotas` INT(6) NOT NULL,
  `monto_por_cuotas` INT(10) NOT NULL,
  `usuario_id` INT(11) NOT NULL,
  PRIMARY KEY (`prestamo_id`),
  UNIQUE INDEX `monto_por_cuotas_UNIQUE` (`monto_por_cuotas` ASC) VISIBLE,
  UNIQUE INDEX `cant_cuotas_UNIQUE` (`cant_cuotas` ASC) VISIBLE,
  INDEX `usuario_prestamo_fk_idx` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `usuario_prestamo_fk`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `challengecashonline1`.`usuario` (`usuario_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table challengecashonline1.usuario
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `challengecashonline1`.`usuario` (
  `usuario_id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(200) NOT NULL,
  `last_name` VARCHAR(200) NOT NULL,
  `dni` VARCHAR(20) NOT NULL,
  `edad` INT(11) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`usuario_id`),
  UNIQUE INDEX `first_name_UNIQUE` (`first_name` ASC) VISIBLE,
  UNIQUE INDEX `last_name_UNIQUE` (`last_name` ASC) VISIBLE,
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
SET FOREIGN_KEY_CHECKS = 1;
