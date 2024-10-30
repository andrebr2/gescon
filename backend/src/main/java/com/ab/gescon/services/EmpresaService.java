package com.ab.gescon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ab.gescon.dto.EmpresaDTO;
import com.ab.gescon.entities.Empresa;
import com.ab.gescon.repositories.EmpresaRepository;
import com.ab.gescon.services.exceptions.DataBaseException;
import com.ab.gescon.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;
	
	@Transactional(readOnly=true)
	public Page<EmpresaDTO> findAll(Pageable pagealbe) {
		Page<Empresa> result = repository.findAll(pagealbe);
		Page<EmpresaDTO> page = result.map(x-> new EmpresaDTO(x));
		return page;
	}
	
	@Transactional(readOnly=true)
	public EmpresaDTO findAll(Long id) {
		Empresa result = repository.findById(id).get();
		EmpresaDTO dto = new EmpresaDTO(result);
		return dto;
	}
	
	@Transactional
	public EmpresaDTO insert(EmpresaDTO dto) {
		Empresa empresa = new Empresa(null, dto.getEmpresa(), dto.getResponsavel());
		empresa = repository.save(empresa);
		return new EmpresaDTO(empresa);
	}
	
	@Transactional
	public EmpresaDTO upDate(Long id, EmpresaDTO dto) {
		try {
			Empresa entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new EmpresaDTO(entity);
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
	
	private void copyDtoToEntity(EmpresaDTO dto, Empresa entity) {
		entity.setEmpresa(dto.getEmpresa());
		entity.setResponsavel(dto.getResponsavel());
	}
}
