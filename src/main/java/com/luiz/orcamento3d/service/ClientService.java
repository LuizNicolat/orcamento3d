package com.luiz.orcamento3d.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.orcamento3d.model.Client;
import com.luiz.orcamento3d.repository.ClientRepository;
import com.luiz.orcamento3d.repository.SupplierRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository cliRepo;

	@Autowired
	SupplierRepository supRepo;

	public Client findById(int id) {
		return cliRepo.getById(id);
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

	public void delete(Integer id) {
		Client Client = cliRepo.findById(id).get();
		if (Client != null) {
			cliRepo.deleteById(id);
		}
	}
 
}
