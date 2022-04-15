package com.luiz.orcamento3d.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.orcamento3d.dto.EstimateDTO;
import com.luiz.orcamento3d.model.Estimate;
import com.luiz.orcamento3d.repository.EstimateRepository;

@Service
public class EstimateService {

	@Autowired
	EstimateRepository estiRepo;

	public Estimate findById(int id) {
		return estiRepo.getById(id);
	}

	public List<Estimate> findAll() {
		return estiRepo.findAll();
	}

	public Estimate create(EstimateDTO fila) {
		return estiRepo.save(new Estimate(
					
				);			
		
	}
//	
//	public Estimate update(EstimateDTO fila) {
//		Estimate estiOld = estiRepo.getById(fila.getFilamentId());
//		
//		if (estiOld != null && supplier_ != null) {
//			estiOld.setSupplierId(supplier_);
//			estiOld.setFilamentPrice(fila.getFilamentPrice());
//			estiOld.setFilamentType(fila.getFilamentType());
//			estiOld.setLastBuyDate(Utils.convertStringToLocalDate(fila.getLastBuyDate()));		
//
//			return estiRepo.save(estiOld);
//		} else {
//			return null;
//		}
//		
//	}
//
//	public void delete(Integer id) {
//		Estimate Estimate = estiRepo.findById(id).get();
//		if (Estimate != null) {
//			estiRepo.deleteById(id);
//		}
//	}
//	
//	
//	public Estimate filamentFromDTO(EstimateDTO filaDTO, Supplier supplier) {
//		Estimate esti = new Estimate();		
//		fila.setSupplierId(supplier);
//		fila.setFilamentType(filaDTO.getFilamentType());
//		fila.setFilamentPrice(filaDTO.getFilamentPrice());
//		fila.setLastBuyDate(LocalDate.parse(filaDTO.getLastBuyDate()));
//		
//		return fila;
//	}
}
