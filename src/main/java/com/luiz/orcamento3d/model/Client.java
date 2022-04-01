package com.luiz.orcamento3d.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CLIENT")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientId;
	private String firstName;
	private String lastName;
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

	public Client(String firstName, String lastName, String firstPhone, String secondPhone, String cpfCgc,
			String address, int addressNumber, String zipCode, String city, String state, String addressComplement,
			String firstEmail, String secondEmail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.firstPhone = firstPhone;
		this.secondPhone = secondPhone;
		this.cpfCgc = cpfCgc;
		this.address = address;
		this.addressNumber = addressNumber;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
		this.addressComplement = addressComplement;
		this.firstEmail = firstEmail;
		this.secondEmail = secondEmail;
	}

}
