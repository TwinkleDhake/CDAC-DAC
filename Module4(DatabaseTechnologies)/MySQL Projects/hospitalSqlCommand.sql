-- --------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hospital
-- -----------------------------------------------------
use hospital;
-- -----------------------------------------------------
-- Table `procedure`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `procedure` (
  `code` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `cost` INT NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `physician`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `physician` (
  `employeeid` INT UNSIGNED NOT NULL,
  `name` VARCHAR(45) NULL,
  `position` VARCHAR(45) NULL,
  `ssn` VARCHAR(45) NULL,
  `physiciancol` VARCHAR(45) NULL,
  PRIMARY KEY (`employeeid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trained_in`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trained_in` (
  `physician` INT UNSIGNED NOT NULL,
  `treatment` INT NOT NULL,
  `certificationdate` TIMESTAMP(5) NULL,
  `certificationexpires` TIMESTAMP(5) NULL,
  INDEX `FK_Phy1_idx` (`physician` ASC) VISIBLE,
  INDEX `FK_treatment_idx` (`treatment` ASC) VISIBLE,
  PRIMARY KEY (`physician`, `treatment`),
  CONSTRAINT `FK_Phy1`
    FOREIGN KEY (`physician`)
    REFERENCES `physician` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_treatment`
    FOREIGN KEY (`treatment`)
    REFERENCES `procedure` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `block`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `block` (
  `blockfloor` INT UNSIGNED NOT NULL,
  `blockcode` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`blockfloor`, `blockcode`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `room` (
  `roomnumber` INT UNSIGNED NOT NULL,
  `roomtype` VARCHAR(45) NULL,
  `blockfloor` INT UNSIGNED NULL,
  `blockcode` INT UNSIGNED NULL,
  `unavailable` TINYINT NULL,
  PRIMARY KEY (`roomnumber`),
  INDEX `fk_parent_block_idx` (`blockfloor` ASC, `blockcode` ASC) VISIBLE,
  CONSTRAINT `fk_parent_block`
    FOREIGN KEY (`blockfloor` , `blockcode`)
    REFERENCES `block` (`blockfloor` , `blockcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patient` (
  `ssn` INT UNSIGNED NOT NULL,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `insuranceid` INT NULL,
  `pcp` INT UNSIGNED NULL,
  PRIMARY KEY (`ssn`),
  INDEX `FK_pat_phy_idx` (`pcp` ASC) VISIBLE,
  CONSTRAINT `FK_pat_phy`
    FOREIGN KEY (`pcp`)
    REFERENCES `physician` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stay`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stay` (
  `stayid` INT UNSIGNED NOT NULL,
  `patient` INT UNSIGNED NULL,
  `room` INT UNSIGNED NULL,
  `start_date` TIMESTAMP(5) NULL,
  `end_time` TIMESTAMP(5) NULL,
  `staycol` VARCHAR(45) NULL,
  PRIMARY KEY (`stayid`),
  INDEX `fk_stay_patient_idx` (`patient` ASC) VISIBLE,
  INDEX `fk_stay_room_idx` (`room` ASC) VISIBLE,
  CONSTRAINT `fk_stay_patient`
    FOREIGN KEY (`patient`)
    REFERENCES `patient` (`ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_stay_room`
    FOREIGN KEY (`room`)
    REFERENCES `room` (`roomnumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nurse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nurse` (
  `employeeid` INT UNSIGNED NOT NULL,
  `name` VARCHAR(45) NULL,
  `position` VARCHAR(45) NULL,
  `registered` TINYINT NULL,
  `ssn` INT NULL,
  PRIMARY KEY (`employeeid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `department` (
  `departmentid` INT UNSIGNED NOT NULL,
  `name` VARCHAR(45) NULL,
  `head` INT UNSIGNED NULL,
  PRIMARY KEY (`departmentid`),
  INDEX `fk_head_idx` (`head` ASC) VISIBLE,
  CONSTRAINT `fk_head`
    FOREIGN KEY (`head`)
    REFERENCES `physician` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `affiliated_with`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `affiliated_with` (
  `physician` INT UNSIGNED NOT NULL,
  `department` INT UNSIGNED NOT NULL,
  `primaryaffiliation` TINYINT NULL,
  INDEX `FK_Phys_idx` (`physician` ASC) VISIBLE,
  INDEX `FK_dept_idx` (`department` ASC) VISIBLE,
  PRIMARY KEY (`physician`, `department`),
  CONSTRAINT `FK_Phys`
    FOREIGN KEY (`physician`)
    REFERENCES `physician` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_dept`
    FOREIGN KEY (`department`)
    REFERENCES `department` (`departmentid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medication` (
  `code` INT UNSIGNED NOT NULL,
  `name` VARCHAR(45) NULL,
  `brand` VARCHAR(45) NULL,
  `description` VARCHAR(200) NULL,
  `medicationcol` VARCHAR(45) NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `appointment` (
  `appointmentid` INT UNSIGNED NOT NULL,
  `patient` INT UNSIGNED NULL,
  `prepnurse` INT UNSIGNED NULL,
  `physician` INT UNSIGNED NULL,
  `examinationroom` VARCHAR(45) NULL,
  `start_dt_time` TIMESTAMP(5) NULL,
  `end_dt_time` TIMESTAMP(5) NULL,
  PRIMARY KEY (`appointmentid`),
  INDEX `fk_app_pat_idx` (`patient` ASC) VISIBLE,
  INDEX `pk_app_phy_idx` (`physician` ASC) VISIBLE,
  INDEX `fk_app_nurse_idx` (`prepnurse` ASC) VISIBLE,
  CONSTRAINT `fk_app_pat`
    FOREIGN KEY (`patient`)
    REFERENCES `patient` (`ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_app_phy`
    FOREIGN KEY (`physician`)
    REFERENCES `physician` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_app_nurse`
    FOREIGN KEY (`prepnurse`)
    REFERENCES `nurse` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `prescribe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prescribe` (
  `physician` INT UNSIGNED NOT NULL,
  `patient` INT UNSIGNED NOT NULL,
  `medication` INT UNSIGNED NOT NULL,
  `date` TIMESTAMP NOT NULL,
  `appointment` INT UNSIGNED NULL,
  `dose` VARCHAR(45) NULL,
  INDEX `fk_phy_pres_idx` (`physician` ASC) VISIBLE,
  INDEX `fk_med_idx` (`medication` ASC) VISIBLE,
  INDEX `fk_patient_idx` (`patient` ASC) VISIBLE,
  PRIMARY KEY (`physician`, `patient`, `medication`, `date`),
  INDEX `fp_pres_app_idx` (`appointment` ASC) VISIBLE,
  CONSTRAINT `fk_phy_pres`
    FOREIGN KEY (`physician`)
    REFERENCES `physician` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_med`
    FOREIGN KEY (`medication`)
    REFERENCES `medication` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_patient`
    FOREIGN KEY (`patient`)
    REFERENCES `patient` (`ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fp_pres_app`
    FOREIGN KEY (`appointment`)
    REFERENCES `appointment` (`appointmentid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `undergoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `undergoes` (
  `patient` INT UNSIGNED NOT NULL,
  `procwdure` INT NULL,
  `stay` INT UNSIGNED NULL,
  `date` TIMESTAMP(5) NULL,
  `physician` INT UNSIGNED NULL,
  `assistingmurse` INT UNSIGNED NULL,
  INDEX `fk_und_patient_idx` (`patient` ASC) VISIBLE,
  INDEX `fk_und_procedure_idx` (`procwdure` ASC) VISIBLE,
  INDEX `fp_und_stay_idx` (`stay` ASC) VISIBLE,
  INDEX `fk_und_phy_idx` (`physician` ASC) VISIBLE,
  INDEX `fk_und_nurse_idx` (`assistingmurse` ASC) VISIBLE,
  CONSTRAINT `fk_und_patient`
    FOREIGN KEY (`patient`)
    REFERENCES `patient` (`ssn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_und_procedure`
    FOREIGN KEY (`procwdure`)
    REFERENCES `procedure` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fp_und_stay`
    FOREIGN KEY (`stay`)
    REFERENCES `stay` (`stayid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_und_phy`
    FOREIGN KEY (`physician`)
    REFERENCES `physician` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_und_nurse`
    FOREIGN KEY (`assistingmurse`)
    REFERENCES `nurse` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `on_call`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `on_call` (
  `nurse` INT UNSIGNED NOT NULL,
  `blockfloor` INT UNSIGNED NOT NULL,
  `blockcode` INT UNSIGNED NOT NULL,
  `oncallstart` TIMESTAMP NOT NULL,
  `oncallend` TIMESTAMP NOT NULL,
  INDEX `fk_on_call_nurse_idx` (`nurse` ASC) VISIBLE,
  INDEX `fk_block_idx` (`blockfloor` ASC, `blockcode` ASC) VISIBLE,
  PRIMARY KEY (`nurse`, `blockfloor`, `blockcode`, `oncallstart`, `oncallend`),
  CONSTRAINT `fk_on_call_nurse`
    FOREIGN KEY (`nurse`)
    REFERENCES `nurse` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_block`
    FOREIGN KEY (`blockfloor` , `blockcode`)
    REFERENCES `block` (`blockfloor` , `blockcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
