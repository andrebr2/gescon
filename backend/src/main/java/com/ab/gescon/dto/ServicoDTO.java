package com.ab.gescon.dto;

import com.ab.gescon.entities.Servico;

public class ServicoDTO {

	private Long id;
	private String servico;
	
	public ServicoDTO() {

	}

	public ServicoDTO(Long id, String servico) {
		this.id = id;
		this.servico = servico;
	}
	
	public ServicoDTO(Servico serv) {
		id = serv.getId();
		servico = serv.getServico();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}
	
	
	
}
