package com.ab.gescon.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contrato")
public class Contrato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String objetoContrato;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Double latitude;
	private Double longitude;
	private Double valor;

	@ManyToOne
	@JoinColumn(name = "servico_id")
	private Servico servico;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	public Contrato() {

	}

	public Contrato(Long id, String objetoContrato, LocalDate dataInicio, LocalDate dataFim, Double latitude,
			Double longitude, Double valor, Servico servico, Empresa empresa) {
		this.id = id;
		this.objetoContrato = objetoContrato;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.latitude = latitude;
		this.longitude = longitude;
		this.valor = valor;
		this.servico = servico;
		this.empresa = empresa;
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
	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	

	public Servico getServico() {
		return servico;
	}
	
	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contrato other = (Contrato) obj;
		return Objects.equals(id, other.id);
	}

}
