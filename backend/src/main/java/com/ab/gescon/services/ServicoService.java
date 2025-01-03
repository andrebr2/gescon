package com.ab.gescon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ab.gescon.dto.ServicoDTO;
import com.ab.gescon.entities.Servico;
import com.ab.gescon.repositories.ServicoRepository;
import com.ab.gescon.services.exceptions.DataBaseException;
import com.ab.gescon.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
	
	@Transactional
	public ServicoDTO insert(ServicoDTO dto) {
		Servico servico = new Servico(null, dto.getServico());
		servico = repository.save(servico);
		return new ServicoDTO(servico);
	}
	
	@Transactional
	public ServicoDTO upDate(Long id, ServicoDTO dto) {
		try {
			Servico entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ServicoDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity violation.");
		}
	}
	
	private void copyDtoToEntity(ServicoDTO dto, Servico entity) {
		entity.setServico(dto.getServico());
	}
	
}
