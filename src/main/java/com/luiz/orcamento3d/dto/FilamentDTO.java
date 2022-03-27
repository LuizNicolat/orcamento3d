package com.luiz.orcamento3d.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilamentDTO {
	private int SupplierId;
	private String filamentType;
	private double filamentPrice;
	private String lastBuyDate;
}
