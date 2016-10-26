package com.TrabalhoTecWeb.Model;

import java.sql.Date;
import java.sql.Time;

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

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="evento",schema="tecweb")
public class Evento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_EVENTO")
	private Integer id;
	
	@Column(name="NOME")
	@NotBlank(message="O campo nome deve ser informado")
	@Size(max=100,message="O nome deve possuir no máximo 100 caracteres")
	private String nome;
	
	@Column(name="DATA")
	@NotBlank(message="O campo data deve ser informado")
	private Date data;
	
	@Column(name="HORA")
	@NotBlank(message="O campo hora deve ser informado")
	private Time hora;
	
	@Column(name="CAPACIDADE")
	@NotBlank(message="O campo capacidade deve ser informado")
	private Integer capacidade;
	
	@Column(name="DURACAO")
	@NotBlank(message="O campo duracao deve ser informado")
	private Time duracao;

	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	@JoinColumn(name="ID_ENDERECO")
	@JsonInclude(Include.NON_NULL)
	@Valid
	@NotNull(message="Os dados do local devem ser informados")
	private Endereco local;
	
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Endereco getLocal() {
		return local;
	}

	public void setLocal(Endereco local) {
		this.local = local;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
}
