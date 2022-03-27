package com.luiz.orcamento3d.dto;

import com.luiz.orcamento3d.model.Filament;
import com.luiz.orcamento3d.utils.Utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilamentFindByIdDTO {
	private String supplierName;
	private String filamentType;
	private double filamentPrice;
	private String lastBuyDate;

	public FilamentFindByIdDTO(Filament filament_) {
		this.supplierName = filament_.getSupplierId().getSupplierName();
		this.filamentType = filament_.getFilamentType();
		this.filamentPrice = filament_.getFilamentPrice();
		this.lastBuyDate = Utils.convertLocalDateToString(filament_.getLastBuyDate());
	}
}
