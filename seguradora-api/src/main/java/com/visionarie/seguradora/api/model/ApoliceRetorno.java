package com.visionarie.seguradora.api.model;
import java.math.BigDecimal;

public class ApoliceRetorno {
	
	private Integer numeroApolice;
	private String placaVeiculo;
	private BigDecimal valorApolice;

	private String vencimentoApolice;
	private String mensagem;
	
	public Integer getNumeroApolice() {
		return numeroApolice;
	}

	public void setNumeroApolice(Integer numeroApolice) {
		this.numeroApolice = numeroApolice;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public BigDecimal getValorApolice() {
		return valorApolice;
	}

	public void setValorApolice(BigDecimal valorApolice) {
		this.valorApolice = valorApolice;
	}

	public String getVencimentoApolice() {
		return vencimentoApolice;
	}

	public void setVencimentoApolice(String vencimentoApolice) {
		this.vencimentoApolice = vencimentoApolice;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	

}
