package com.luiz.orcamento3d.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estimate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int estimateId;
	
	private double partsTotalCost;
	private double expensestotalCost;

	@OneToMany
	private List<Part> listParts;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id", referencedColumnName = "clientId")
	private Client clientId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "filament_id", referencedColumnName = "filamentId")
	private Filament filamentId;

	public Estimate(double partsTotalCost, double expensestotalCost, List<Part> listParts, Client clientId,
			Filament filamentId) {
		super();
		this.partsTotalCost = partsTotalCost;
		this.expensestotalCost = expensestotalCost;
		this.listParts = listParts;
		this.clientId = clientId;
		this.filamentId = filamentId;
	}
}
