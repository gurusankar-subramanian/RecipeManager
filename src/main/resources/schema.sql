DROP ALL OBJECTS;

  



CREATE  TABLE  `receipe` (
`id` INT NOT NULL AUTO_INCREMENT  ,
`name` VARCHAR(45) NULL , 
PRIMARY KEY (`id`) );



CREATE  TABLE `incredient` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL , 
  `receipe_id` INT NOT NULL , 
  PRIMARY KEY (`id`) , 
  CONSTRAINT `receipe_id_fk`
    FOREIGN KEY (`receipe_id` )
    REFERENCES `receipe` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
 

-- ALTER TABLE `tasks` DROP FOREIGN KEY `status_id` ;

--ALTER TABLE `tasks` 
--ADD CONSTRAINT `status_id_fk`
--FOREIGN KEY (`status_id` )
--REFERENCES `status_master` (`id` )
--ON DELETE NO ACTION
--ON UPDATE NO ACTION;
