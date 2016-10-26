package com.TrabalhoTecWeb.Model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

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
	
	@Column(name="LOCAL")
	@NotBlank(message="O campo local deve ser informado")
	private String local;
	
	@Column(name="CAPACIDADE")
	@NotBlank(message="O campo capacidade deve ser informado")
	private Integer capacidade;

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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
}
