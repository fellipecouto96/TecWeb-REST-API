package com.TrabalhoTecWeb.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="cliente",schema="tecweb")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CLIENTE")
	private Integer id;
	
	@Column(name="NOME")
	@NotBlank(message="O campo nome deve ser informado")
	@Size(max=100,message="O nome deve possuir no máximo 100 caracteres")
	private String nome;
	
	@Email(message="Os dados informados no campo email não são válidos.")
	@Column(name="EMAIL")
	@NotBlank(message="O campo email deve ser informado")
	@Size(max=120,message="O nome deve possuir no máximo 120 caracteres")
	private String email;
	
	@CPF(message="Os dados informados no campo cpf não são válidos.")
	@NotNull(message="O campo cpf deve ser informado")
	@Column(name="CPF")
	private String cpf;
	
	@NotNull(message="O campo senha deve ser informado")
	@Column(name="SENHA")
	@Size(max=10,message="A senha deve possuir no máximo 10 caracteres.")
	private String senha;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	@JoinColumn(name="ID_ENDERECO")
	@JsonInclude(Include.NON_NULL)
	@Valid
	@NotNull(message="Os dados do Endereço devem ser informados")
	private Endereco endereco;
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
