package com.luiz.orcamento3d.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.Data;

@MappedSuperclass
@Data
@Table(name="PERSON")
public abstract class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private String cpfCgc;
	private String address;
	private int addressNumber;
	private String zipCode;
	private String city;
	private String state;
	private String addressComplement;

}
