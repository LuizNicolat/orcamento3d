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

import com.luiz.orcamento3d.dto.FilamentDTO;
import com.luiz.orcamento3d.dto.FilamentFindByIdDTO;
import com.luiz.orcamento3d.model.Filament;
import com.luiz.orcamento3d.service.FilamentService;

@RestController
@RequestMapping(value = "/filament")
public class FilamentController {

	@Autowired
	FilamentService filaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<FilamentFindByIdDTO> findById(@PathVariable int id) {
		Filament fila = filaService.findById(id);

		if (fila == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(new FilamentFindByIdDTO(fila));
		}
	}

	@GetMapping
	public ResponseEntity<List<FilamentFindByIdDTO>> findAll() {
		List<FilamentFindByIdDTO> list = filaService.findAll().stream().map(obj -> new FilamentFindByIdDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok(list);
	}

	@PostMapping
	public ResponseEntity<FilamentDTO> create(@RequestBody FilamentDTO filament_) {
		Filament fila = filaService.create(filament_);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fila.getFilamentId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public ResponseEntity<FilamentDTO> update(@RequestBody FilamentDTO filament_) {
		Filament fila = filaService.update(filament_);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/"+fila.getFilamentId()).buildAndExpand(fila.getFilamentId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		filaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
