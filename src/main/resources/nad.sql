INSERT INTO `db_orcamentos3d`.`client` (`address`, `address_number`, `city`, `cpf_cgc`, `first_email`, `first_name`, `first_phone`, `last_name`, `state`, `zip_code`) VALUES ('Rua Centenario', '456', 'Curitiba', '00011122233', 'jose@gmail.com', 'José', '190', 'Silva', 'PR', '80440220');

INSERT INTO `db_orcamentos3d`.`supplier` (`address`, `address_number`, `city`, `cpf_cgc`, `first_email`, `first_phone`, `state`, `supplier_name`, `zip_code`) VALUES ('Rua Batel', '444', 'Curitiba', '111222333474', 'jose@gmail.com', '190', 'PR', 'José 3D', '80440220');

INSERT INTO `db_orcamentos3d`.`filament` (`filament_price`, `filament_type`, `last_buy_date`, `supplier_id`) VALUES ('130.00', 'PLA', '2022-04-05', '1'), ('80', 'ABS', '2022-04-09', '1');

INSERT INTO `db_orcamentos3d`.`expenses` (`extra_expenses`, `kilowatt_hour`, `profit_percentage`) VALUES ('5.0', '0.95', '10');

INSERT INTO `db_orcamentos3d`.`printer` (`printer_brand`, `printer_model`, `printer_potency`, `printer_price`) VALUES ('Creality', 'Ender 3', '270', '1.850');

INSERT INTO `db_orcamentos3d`.`estimate` (`expensestotal_cost`, `parts_total_cost`, `client_id`, `filament_id`) VALUES ('40.00', '60.00', '1', '2');

INSERT INTO `db_orcamentos3d`.`part` (`part_complements`, `part_gcode`, `part_name`, `weight`) VALUES ('anasn', 'nasdasad', 'Rasta', '100'),('anasn', 'nasdasad', 'Cleiton', '25');
