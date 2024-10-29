package com.ab.gescon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ab.gescon.dto.ServicoDTO;
import com.ab.gescon.entities.Servico;
import com.ab.gescon.repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository repository;
	
	@Transactional(readOnly=true)
	public Page<ServicoDTO> findAll(Pageable pagealbe) {
		Page<Servico> result = repository.findAll(pagealbe);
		Page<ServicoDTO> page = result.map(x-> new ServicoDTO(x));
		return page;
	}
	
	@Transactional(readOnly=true)
	public ServicoDTO findAll(Long id) {
		Servico result = repository.findById(id).get();
		ServicoDTO dto = new ServicoDTO(result);
		return dto;
	}
	
}
