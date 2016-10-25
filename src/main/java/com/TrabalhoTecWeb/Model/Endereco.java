package com.TrabalhoTecWeb.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "endereco", schema = "tecweb")
public class Endereco {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ENDERECO")
	private Integer id;
	
	@Column(name="CEP")
	@NotNull(message="O campo cep deve ser informado")
	@Size(max=8,message="O cep deve possuir no máximo 8 caracteres")
	private String cep;
	
	@Column(name="LOGRADOURO")
	@NotBlank(message="O campo logradouro deve ser informado")
	@Size(max=100,message="O logradouro deve possuir no máximo 100 caracteres")
	private String logradouro;
	
	@Column(name="NUMERO")
	@NotNull(message="O campo número deve ser informado")
	private Integer numero;
	
	@Column(name="BAIRRO")
	@NotBlank(message="O campo bairro deve ser informado")
	@Size(max=80,message="O bairro deve possuir no máximo 8 caracteres")
	private String bairro;
	
	@Column(name="CIDADE")
	@NotBlank(message="O campo cidade deve ser informado")
	@Size(max=80,message="A cidade deve possuir no máximo 8 caracteres")
	private String cidade;
	
	@Column(name="ESTADO")
	@NotBlank(message="O campo estado deve ser informado")
	@Size(max=2,message="O estado deve possuir no máximo 2 caracteres")
	private String estado;
	
	@Column(name="COMPLEMENTO")
	@JsonInclude(Include.NON_NULL)
	@Size(max=60,message="O complemento deve possuir no máximo 60 caracteres")
	private String complemento;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
