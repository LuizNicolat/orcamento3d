package com.luiz.orcamento3d.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Filament implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int filamentId;

	@ManyToOne
	@JoinColumn(name = "supplierId", nullable = false)
	private Supplier supplierId;
	private String filamentType;
	private double filamentPrice;
	private LocalDate lastBuyDate;

	public Filament(Supplier supplierId, String filamentType, double filamentPrice, LocalDate lastBuyDate) {
		super();
		this.supplierId = supplierId;
		this.filamentType = filamentType;
		this.filamentPrice = filamentPrice;
		this.lastBuyDate = lastBuyDate;
	}

}
