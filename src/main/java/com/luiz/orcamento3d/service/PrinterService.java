package com.luiz.orcamento3d.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.orcamento3d.model.Printer;
import com.luiz.orcamento3d.repository.PrinterRepository;

@Service
public class PrinterService {

	@Autowired
	PrinterRepository printerRepo;

	public Printer findById(int id) {
		return printerRepo.findById(id).get();
	}

	public List<Printer> findAll() {
		return printerRepo.findAll();
	}

	public Printer create(Printer printer_) {
		return printerRepo.save(new Printer(
					printer_.getPrinterBrand(), 
					printer_.getPrinterModel(), 
					printer_.getPrinterPrice(), 
					printer_.getPrinterPotency()
					)
				);				
	}
	
	public Printer update(Printer printer_) {
		//Filament fila_ = filamentFromDTO(fila, supplier_);
		Printer printerOld = printerRepo.getById(printer_.getPrinterId());
		
		if (printerOld != null) {
			printerOld.setPrinterBrand(printer_.getPrinterBrand()); 
			printerOld.setPrinterModel(printer_.getPrinterModel());
			printerOld.setPrinterPrice(printer_.getPrinterPrice());
			printerOld.setPrinterPotency(printer_.getPrinterPotency());

			return printerRepo.save(printerOld);
		} else {
			return null;
		}
		
	}

	public void delete(Integer id) {
		Printer Printer = printerRepo.findById(id).get();
		if (Printer != null) {
			printerRepo.deleteById(id);
		}
	}
 
}
