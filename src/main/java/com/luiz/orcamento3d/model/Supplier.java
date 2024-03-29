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
@Table(name = "SUPPLIER")
public class Supplier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplierId;
	private String supplierName;
	private String firstPhone;
	private String secondPhone;
	private String cpfCgc;
	private String address;
	private int addressNumber;
	private String zipCode;
	private String city;
	private String state;
	private String addressComplement;
	private String firstEmail;
	private String secondEmail;

}
