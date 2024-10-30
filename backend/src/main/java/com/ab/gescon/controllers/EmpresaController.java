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

import com.ab.gescon.dto.EmpresaDTO;
import com.ab.gescon.services.EmpresaService;

@RestController
@RequestMapping(value="/empresas")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresa;
	
	@GetMapping
	public Page<EmpresaDTO> findAll(Pageable pageable) {
		return empresa.findAll(pageable);
	}
	
	@GetMapping(value="/{id}")
	public EmpresaDTO findById(@PathVariable Long id) {
		return empresa.findAll(id);
	}


	
	@PostMapping
	public ResponseEntity<EmpresaDTO> insert(@RequestBody EmpresaDTO dto) {
		dto = empresa.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<EmpresaDTO> upDate(@PathVariable Long id, @RequestBody EmpresaDTO dto) {
		dto = empresa.upDate(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<EmpresaDTO> delete(@PathVariable Long id) {
		empresa.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
