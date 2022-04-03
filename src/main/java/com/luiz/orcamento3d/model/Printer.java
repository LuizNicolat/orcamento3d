package com.luiz.orcamento3d.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PRINTER")
public class Printer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int printerId;
	private String printerBrand;
	private String printerModel;
	private double printerPrice;
	private int printerPotency;
	
	public Printer(String brand, String model, double price, int potency) {
		this.printerBrand = brand;
		this.printerModel = model;
		this.printerPrice = price;
		this.printerPotency = potency;
	}	
	
	public Printer(Printer printer) {
		this.printerId = printer.printerId;
		this.printerBrand = printer.printerBrand;
		this.printerModel = printer.printerModel;
		this.printerPrice = printer.printerPrice;
		this.printerPotency = printer.printerPotency;
	}
	
}
