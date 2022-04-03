package com.luiz.orcamento3d.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.orcamento3d.model.Client;
import com.luiz.orcamento3d.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository cliRepo;

	public Client findById(int id) {
		return cliRepo.findById(id).get();
	}

	public List<Client> findAll() {
		return cliRepo.findAll();
	}

	public Client create(Client cli_) {
		return cliRepo.save(new Client(
				cli_.getFirstName(), 
				cli_.getLastName(), 
				cli_.getFirstPhone(), 
				cli_.getSecondPhone(), 
				cli_.getCpfCgc(), 
				cli_.getAddress(), 
				cli_.getAddressNumber(), 
				cli_.getZipCode(), 
				cli_.getCity(), 
				cli_.getState(), 
				cli_.getAddressComplement(), 
				cli_.getFirstEmail(), 
				cli_.getSecondEmail()));
	}
	
	public Client update(Client client_) {
		//Filament fila_ = filamentFromDTO(fila, supplier_);
		Client cliOld = cliRepo.getById(client_.getClientId());
		
		if (cliOld != null) {
			cliOld.setFirstName(client_.getFirstName()); 
			cliOld.setLastName(client_.getLastName());
			cliOld.setFirstPhone(client_.getFirstPhone());
			cliOld.setSecondPhone(client_.getSecondPhone()); 
			cliOld.setCpfCgc(client_.getCpfCgc());
			cliOld.setAddress(client_.getAddress()); 
			cliOld.setAddressNumber(client_.getAddressNumber()); 
			cliOld.setZipCode(client_.getZipCode());
			cliOld.setCity(client_.getCity());
			cliOld.setState(client_.getState()); 
			cliOld.setAddressComplement(client_.getAddressComplement()); 
			cliOld.setFirstEmail(client_.getFirstEmail());
			cliOld.setSecondEmail(client_.getSecondEmail());		

			return cliRepo.save(cliOld);
		} else {
			return null;
		}
		
	}

	public void delete(Integer id) {
		Client Client = cliRepo.findById(id).get();
		if (Client != null) {
			cliRepo.deleteById(id);
		}
	}
 
}
