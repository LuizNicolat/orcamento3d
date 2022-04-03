package com.luiz.orcamento3d.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luiz.orcamento3d.model.Client;
import com.luiz.orcamento3d.service.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

	@Autowired
	ClientService cliService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable int id) {
		Client client = cliService.findById(id);

		if (client == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(client);
		}
	}

	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = cliService.findAll().stream().map(obj -> new Client(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok(list);
	}

	@PostMapping
	public ResponseEntity<Client> create(@RequestBody Client client_) {
		Client client = cliService.create(client_);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getClientId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public ResponseEntity<Client> update(@RequestBody Client client_) {
		Client client = cliService.update(client_);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/"+client.getClientId()).buildAndExpand(client.getClientId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		cliService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
