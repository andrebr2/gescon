package com.ab.gescon.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.ab.gescon.dto.ContratoDTO;
import com.ab.gescon.services.ContratoService;

@RestController
@RequestMapping(value="/contratos")
public class ContratoController {

	@Autowired
	private ContratoService contrato;
	
	@GetMapping
	public Page<ContratoDTO> findAll(Pageable pageable) {
		return contrato.findAll(pageable);
	}
	
	@GetMapping(value="/{id}")
	public ContratoDTO findById(@PathVariable Long id) {
		return contrato.findAll(id);
	}
	
	@PostMapping
	public ResponseEntity<ContratoDTO> insert(@RequestBody ContratoDTO dto) {
		dto = contrato.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ContratoDTO> upDate(@PathVariable Long id, @RequestBody ContratoDTO dto) {
		dto = contrato.upDate(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<ContratoDTO> delete(@PathVariable Long id) {
		contrato.delete(id);
		return ResponseEntity.noContent().build();
	}
}
