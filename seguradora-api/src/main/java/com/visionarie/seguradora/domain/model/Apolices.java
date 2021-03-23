package com.visionarie.seguradora.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Apolices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDAPOLICES")
	private Long idApolice;

	@Column(name = "NUMEROAPOLICE")
	private Long numeroApolice;

	@Column(name = "INICIOVIGENCIA")
	private Date inicioVigencia;

	@Column(name = "FIMVIGENCIA")
	private Date fimVigencia;

	@Column(name = "PLACAVEICULO")
	private String placaVeiculo;

	@Column(name = "VALORAPOLICE")
	private BigDecimal valorApolice;

	@Column(name = "IDCLIENTE")
	private Long idCliente;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdApolice() {
		return idApolice;
	}

	public void setIdApolice(Long idApolice) {
		this.idApolice = idApolice;
	}

	public Long getNumeroApolice() {
		return numeroApolice;
	}

	public void setNumeroApolice(Long numeroApolice) {
		this.numeroApolice = numeroApolice;
	}

	public Date getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(Date inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public Date getFimVigencia() {
		return fimVigencia;
	}

	public void setFimVigencia(Date fimVigencia) {
		this.fimVigencia = fimVigencia;
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

}
