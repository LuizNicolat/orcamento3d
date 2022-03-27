package com.luiz.orcamento3d.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Part implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int partId;

	private String partName;
	private String partGcode;
	private String partComplements;
	private double weight;

	@ManyToOne(fetch = FetchType.LAZY)
	private Estimate estimate;
}
