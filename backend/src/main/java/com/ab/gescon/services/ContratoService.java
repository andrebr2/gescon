package com.ab.gescon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ab.gescon.dto.ContratoDTO;
import com.ab.gescon.entities.Contrato;
import com.ab.gescon.repositories.ContratoRepository;
import com.ab.gescon.services.exceptions.DataBaseException;
import com.ab.gescon.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContratoService {

	@Autowired
	private ContratoRepository repository;
	
	@Transactional(readOnly=true)
	public Page<ContratoDTO> findAll(Pageable pagealbe) {
		Page<Contrato> result = repository.findAll(pagealbe);
		Page<ContratoDTO> page = result.map(x-> new ContratoDTO(x));
		return page;
	}
	
	@Transactional(readOnly=true)
	public ContratoDTO findAll(Long id) {
		Contrato result = repository.findById(id).get();
		ContratoDTO dto = new ContratoDTO(result);
		return dto;
	}
	
	@Transactional
	public ContratoDTO insert(ContratoDTO dto) {
		Contrato entity = new Contrato();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ContratoDTO(entity);
	}
	
	@Transactional
	public ContratoDTO upDate(Long id, ContratoDTO dto) {
		try {
			Contrato entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ContratoDTO(entity);
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
	
	private void copyDtoToEntity(ContratoDTO dto, Contrato entity) {
		entity.setObjetoContrato(dto.getObjetoContrato());
		entity.setDataInicio(dto.getDataInicio());
		entity.setDataFim(dto.getDataFim());
		entity.setLatitude(dto.getLatitude());
		entity.setLongitude(dto.getLongitude());
		
	}
}
