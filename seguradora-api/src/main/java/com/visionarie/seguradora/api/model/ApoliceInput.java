package com.visionarie.seguradora.api.model;

import javax.validation.constraints.NotBlank;

public class ApoliceInput {
	
	@NotBlank
	private Integer numeroApolice;

	public Integer getNumeroApolice() {
		return numeroApolice;
	}

	public void setNumeroApolice(Integer numeroApolice) {
		this.numeroApolice = numeroApolice;
	}


}
