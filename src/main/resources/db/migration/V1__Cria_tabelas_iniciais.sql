-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db_soat
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_soat
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_soat_pedido` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `db_soat_pedido` ;


-- -----------------------------------------------------
-- Table `db_soat`.`tb_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_soat_pedido`.`tb_pedido` (
                                                     `numero_pedido` BIGINT NOT NULL AUTO_INCREMENT,
                                                     `data_pedido` DATETIME NOT NULL,
                                                     `valor_total` DECIMAL(10,2) NOT NULL,
    `etapa` ENUM('RECEBIDO', 'EM_PREPARACAO', 'PRONTO', 'FINALIZADO') NOT NULL DEFAULT 'RECEBIDO',
    `id_cliente` VARCHAR(255) NULL DEFAULT NULL,
    `id_pagamento` BIGINT NULL DEFAULT NULL,
    `data_mudanca_etapa` DATETIME NULL DEFAULT NULL,
    PRIMARY KEY (`numero_pedido`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 15
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_soat`.`tb_composicao_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_soat_pedido`.`tb_composicao_pedido` (
                                                                `id_composicao` BIGINT NOT NULL AUTO_INCREMENT,
                                                                `id_produto` BIGINT NOT NULL,
                                                                `quantidade` INT NOT NULL,
                                                                `preco_unitario` DECIMAL(10,2) NOT NULL,
    `numero_pedido` BIGINT NOT NULL,
    PRIMARY KEY (`id_composicao`),
    INDEX `FK_COMPOSICAO_ID_PEDIDO_idx` (`numero_pedido` ASC) VISIBLE,
    CONSTRAINT `FK_COMPOSICAO_NUMERO_PEDIDO`
    FOREIGN KEY (`numero_pedido`)
    REFERENCES `db_soat_pedido`.`tb_pedido` (`numero_pedido`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 5
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
