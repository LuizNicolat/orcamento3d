package com.luiz.orcamento3d.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstimateDTO {

	
	private int estimateId;	
	private double partsTotalCost;
	private double expensestotalCost;
	private List<String> partsPrinted;
	private int totalParts;
	private String clientName;
	private String filamentUsed;
}
