package com.luiz.orcamento3d.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.orcamento3d.Enums.Filaments;
import com.luiz.orcamento3d.model.Filament;
import com.luiz.orcamento3d.model.Supplier;
import com.luiz.orcamento3d.repository.FilamentRepository;
import com.luiz.orcamento3d.repository.SupplierRepository;

@Service
public class FilamentService {

	@Autowired
	FilamentRepository filaRepo;

	@Autowired
	SupplierRepository supRepo;

	public Filament findById(int id) {
		return filaRepo.getById(id);
	}

	public List<Filament> findAll() {
		return filaRepo.findAll();
	}

	public Filament create() {
		Supplier supplier_ = supRepo.findById(1).get();
		return filaRepo.save(new Filament(supplier_, Filaments.PLA.name(), 130.00, LocalDate.parse("2022-02-28")));
	}

}
