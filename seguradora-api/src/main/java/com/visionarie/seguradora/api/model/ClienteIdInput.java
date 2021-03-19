package com.visionarie.seguradora.api.model;

import javax.validation.constraints.NotNull;

public class ClienteIdInput {
	
	@NotNull
	private Long idCliente;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
}
