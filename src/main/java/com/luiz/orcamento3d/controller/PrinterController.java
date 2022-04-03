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

import com.luiz.orcamento3d.model.Printer;
import com.luiz.orcamento3d.service.PrinterService;

@RestController
@RequestMapping(value = "/printer")
public class PrinterController {

	@Autowired
	PrinterService printerService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Printer> findById(@PathVariable int id) {
		Printer Printer = printerService.findById(id);

		if (Printer == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(Printer);
		}
	}

	@GetMapping
	public ResponseEntity<List<Printer>> findAll() {
		List<Printer> list = printerService.findAll().stream().map(obj -> new Printer(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok(list);
	}

	@PostMapping
	public ResponseEntity<Printer> create(@RequestBody Printer printer_) {
		Printer Printer = printerService.create(printer_);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Printer.getPrinterId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public ResponseEntity<Printer> update(@RequestBody Printer printer_) {
		Printer Printer = printerService.update(printer_);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/"+Printer.getPrinterId()).buildAndExpand(Printer.getPrinterId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		printerService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
