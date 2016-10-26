CREATE DATABASE `tecweb`;
- -----------------------------------------------------

-- Table `tecweb`.`endereco`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `tecweb`.`endereco` (

  `ID_ENDERECO` INT NOT NULL AUTO_INCREMENT ,

  `CEP` VARCHAR(8) NOT NULL ,

  `LOGRADOURO` VARCHAR(100) NOT NULL ,

  `NUMERO` INT NOT NULL ,

  `BAIRRO` VARCHAR(80) NOT NULL ,

  `CIDADE` VARCHAR(80) NOT NULL ,

  `ESTADO` CHAR(2) NOT NULL ,

  `COMPLEMENTO` VARCHAR(60) NULL DEFAULT NULL ,

  PRIMARY KEY (`ID_ENDERECO`) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `tecweb`.`cliente`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `tecweb`.`cliente` (

  `ID_CLIENTE` INT NOT NULL AUTO_INCREMENT ,

  `NOME` VARCHAR(100) NOT NULL ,

  `EMAIL` VARCHAR(120) NOT NULL ,

  `CPF` VARCHAR(11) NOT NULL ,

  `SENHA` VARCHAR(10) NOT NULL ,

  `ID_ENDERECO` INT NULL DEFAULT NULL ,

  PRIMARY KEY (`ID_CLIENTE`) ,

  INDEX `fk_Cliente_Endereco1` (`ID_ENDERECO` ASC) ,

  CONSTRAINT `fk_Cliente_Endereco1`

    FOREIGN KEY (`ID_ENDERECO` )

    REFERENCES `tecweb`.`endereco` (`ID_ENDERECO` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `tecweb`.`evento`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `tecweb`.`evento` (

  `ID_EVENTO` INT NOT NULL AUTO_INCREMENT ,

  `NOME` VARCHAR(100) NOT NULL ,

  `DATA` DATE NOT NULL ,

  `HORA` TIME NOT NULL ,

  `CAPACIDADE` INT NOT NULL ,

  `DURACAO` TIME  NOT NULL ,

  `ID_ENDERECO` INT NOT NULL ,

  PRIMARY KEY (`ID_EVENTO`) ,

  INDEX `fk_evento_endereco1` (`ID_ENDERECO` ASC) ,

  CONSTRAINT `fk_evento_endereco1`

    FOREIGN KEY (`ID_ENDERECO` )

    REFERENCES `tecweb`.`endereco` (`ID_ENDERECO` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `tecweb`.`ingresso`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `tecweb`.`ingresso` (

  `ID_INGRESSO` INT NOT NULL AUTO_INCREMENT ,

  `VALOR` DECIMAL(6,2) NOT NULL ,

  `SETOR` VARCHAR(45) NOT NULL ,

  `LOTE` VARCHAR(45) NOT NULL ,

  `MEIA_ENTRADA` CHAR(1) NOT NULL ,

  `ID_EVENTO` INT NOT NULL ,

  PRIMARY KEY (`ID_INGRESSO`) ,

  INDEX `fk_Ingresso_Evento` (`ID_EVENTO` ASC) ,

  CONSTRAINT `fk_Ingresso_Evento`

    FOREIGN KEY (`ID_EVENTO` )

    REFERENCES `tecweb`.`evento` (`ID_EVENTO` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `tecweb`.`compra`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `tecweb`.`compra` (

  `ID_COMPRA` INT NOT NULL AUTO_INCREMENT ,

  `VALOR_COMPRA` DECIMAL(6,2) NOT NULL ,

  `DATA_HORA_COMPRA` DATETIME NOT NULL ,

  `TIPO_PAGAMENTO` VARCHAR(45) NOT NULL ,

  `ID_CLIENTE` INT NOT NULL ,

  PRIMARY KEY (`ID_COMPRA`) ,

  INDEX `fk_Compra_Cliente1` (`ID_CLIENTE` ASC) ,

  CONSTRAINT `fk_Compra_Cliente1`

    FOREIGN KEY (`ID_CLIENTE` )

    REFERENCES `tecweb`.`cliente` (`ID_CLIENTE` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `tecweb`.`compra_ingresso`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `tecweb`.`compra_ingresso` (

  `ID_COMPRA_INGRESSO` INT NOT NULL AUTO_INCREMENT ,

  `ID_COMPRA` INT NOT NULL ,

  `ID_INGRESSO` INT NOT NULL ,

  `QUANTIDADE` INT NOT NULL ,

  PRIMARY KEY (`ID_COMPRA_INGRESSO`) ,

  INDEX `fk_Compra_has_Ingresso_Compra1` (`ID_COMPRA` ASC) ,

  INDEX `fk_Compra_has_Ingresso_Ingresso1` (`ID_INGRESSO` ASC) ,

  CONSTRAINT `fk_Compra_has_Ingresso_Compra1`

    FOREIGN KEY (`ID_COMPRA` )

    REFERENCES `tecweb`.`compra` (`ID_COMPRA` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_Compra_has_Ingresso_Ingresso1`

    FOREIGN KEY (`ID_INGRESSO` )

    REFERENCES `tecweb`.`ingresso` (`ID_INGRESSO` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;