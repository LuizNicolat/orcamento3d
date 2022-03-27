package com.luiz.orcamento3d.Enums;

public enum Filaments {
	PLA("PLA"),
	PETG("PETG"),
	NYLON("NYLON"),
	TRITAN("TRITAN"),
	TPU("TPU"),
	ABS("ABS");
	
	@SuppressWarnings("unused")
	private final String tipo;
	
	private Filaments(String tipo_) {
		this.tipo = tipo_;
	}
}
