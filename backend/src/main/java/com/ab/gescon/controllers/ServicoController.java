package com.ab.gescon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.gescon.dto.ServicoDTO;
import com.ab.gescon.services.ServicoService;

@RestController
@RequestMapping(value="/servicos")
public class ServicoController {

	@Autowired
	private ServicoService service;
	
	@GetMapping
	public Page<ServicoDTO> findAll(Pageable pageable) {
		return service.findAll(pageable);
	}
	
	@GetMapping(value="/{id}")
	public ServicoDTO findById(@PathVariable Long id) {
		return service.findAll(id);
	}
	
}
