package com.ab.gescon.dto;

import com.ab.gescon.entities.Empresa;

public class EmpresaDTO {
	
	private Long id;
	private String empresa;
	private String responsavel;
	
	public EmpresaDTO() {

	}

	public EmpresaDTO(Long id, String empresa, String responsavel) {
		this.id = id;
		this.empresa = empresa;
		this.responsavel = responsavel;
	}
	
	public EmpresaDTO(Empresa emp) {
		id = emp.getId();
		empresa = emp.getEmpresa();
		responsavel = emp.getResponsavel();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	

}
