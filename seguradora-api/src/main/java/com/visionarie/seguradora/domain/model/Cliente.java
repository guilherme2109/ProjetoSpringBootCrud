package com.visionarie.seguradora.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCLIENTE")
	private Long id;
	
	@NotBlank
	@Size(max = 60, min = 1)
	@Column(name = "NOME")
	private String nome;
	
	@NotBlank
	@Size(max = 200, min = 1)
	@Column(name = "CIDADE")
	private String cidade;
	
	@NotBlank
	@CPF
	@Size(max = 20, min = 1)
	@Column(name = "CPF")
	private String cpf;
	
	@NotBlank
	@Size(max = 2, min = 1)
	@Column(name = "UF")
	private String uf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
