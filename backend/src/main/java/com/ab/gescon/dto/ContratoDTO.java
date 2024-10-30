package com.ab.gescon.dto;

import java.time.LocalDate;

import com.ab.gescon.entities.Contrato;

public class ContratoDTO {

	private Long id;
	private String objetoContrato;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Double latitude;
	private Double longitude;
	
	private ServicoDTO servico;
	
	private EmpresaDTO empresa;
	
	public ContratoDTO() {

	}

	public ContratoDTO(Long id, String objetoContrato, LocalDate dataInicio, LocalDate dataFim, Double latitude,
			Double longitude, ServicoDTO servico, EmpresaDTO empresa) {
		this.id = id;
		this.objetoContrato = objetoContrato;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.latitude = latitude;
		this.longitude = longitude;
		this.servico = servico;
		this.empresa = empresa;
	}
	
	public ContratoDTO(Contrato contrato) {
		id = contrato.getId();
		objetoContrato = contrato.getObjetoContrato();
		dataInicio = contrato.getDataInicio();
		dataFim = contrato.getDataFim();
		latitude = contrato.getLatitude();
		longitude = contrato.getLongitude();
		servico = new ServicoDTO(contrato.getServico());
		empresa = new EmpresaDTO(contrato.getEmpresa());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObjetoContrato() {
		return objetoContrato;
	}

	public void setObjetoContrato(String objetoContrato) {
		this.objetoContrato = objetoContrato;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public ServicoDTO getServico() {
		return servico;
	}

	public void setServico(ServicoDTO servico) {
		this.servico = servico;
	}

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}
	
	
	
	
}
