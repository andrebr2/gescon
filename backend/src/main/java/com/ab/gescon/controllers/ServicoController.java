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

import com.ab.gescon.dto.ServicoDTO;
import com.ab.gescon.services.ServicoService;

@RestController
@RequestMapping(value="/servicos")
public class ServicoController {

	@Autowired
	private ServicoService servico;
	
	@GetMapping
	public Page<ServicoDTO> findAll(Pageable pageable) {
		return servico.findAll(pageable);
	}
	
	@GetMapping(value="/{id}")
	public ServicoDTO findById(@PathVariable Long id) {
		return servico.findAll(id);
	}
	
	@PostMapping
	public ResponseEntity<ServicoDTO> insert(@RequestBody ServicoDTO dto) {
		dto = servico.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ServicoDTO> upDate(@PathVariable Long id, @RequestBody ServicoDTO dto) {
		dto = servico.upDate(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<ServicoDTO> delete(@PathVariable Long id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
