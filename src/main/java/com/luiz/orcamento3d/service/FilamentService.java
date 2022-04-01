package com.luiz.orcamento3d.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.orcamento3d.dto.FilamentDTO;
import com.luiz.orcamento3d.model.Filament;
import com.luiz.orcamento3d.model.Supplier;
import com.luiz.orcamento3d.repository.FilamentRepository;
import com.luiz.orcamento3d.repository.SupplierRepository;
import com.luiz.orcamento3d.utils.Utils;

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

	public Filament create(FilamentDTO fila) {
		Supplier supplier_ = supRepo.findById(fila.getSupplierId()).get();
		if(supplier_ != null) {
			return filaRepo.save(new Filament(supplier_, fila.getFilamentType(), fila.getFilamentPrice(), Utils.convertStringToLocalDate(fila.getLastBuyDate())));			
		} else {
			return null;
		}
	}
	
	public Filament update(FilamentDTO fila) {
		Supplier supplier_ = supRepo.findById(fila.getSupplierId()).get();
		//Filament fila_ = filamentFromDTO(fila, supplier_);
		Filament filaOld = filaRepo.getById(fila.getFilamentId());
		
		if (filaOld != null && supplier_ != null) {
			filaOld.setSupplierId(supplier_);
			filaOld.setFilamentPrice(fila.getFilamentPrice());
			filaOld.setFilamentType(fila.getFilamentType());
			filaOld.setLastBuyDate(Utils.convertStringToLocalDate(fila.getLastBuyDate()));		

			return filaRepo.save(filaOld);
		} else {
			return null;
		}
		
	}

	public void delete(Integer id) {
		Filament filament = filaRepo.findById(id).get();
		if (filament != null) {
			filaRepo.deleteById(id);
		}
	}
	
	
	public Filament filamentFromDTO(FilamentDTO filaDTO, Supplier supplier) {
		Filament fila = new Filament();		
		fila.setSupplierId(supplier);
		fila.setFilamentType(filaDTO.getFilamentType());
		fila.setFilamentPrice(filaDTO.getFilamentPrice());
		fila.setLastBuyDate(LocalDate.parse(filaDTO.getLastBuyDate()));
		
		return fila;
	}
}
