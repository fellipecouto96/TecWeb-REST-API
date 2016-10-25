package com.TrabalhoTecWeb.Model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ingresso",schema="tecweb")
public class Ingresso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_INGRESSO")
	private Integer id;
	
	@Column(name="VALOR")
	private BigDecimal valor;
	
	@Column(name="SETOR")
	private String setor;
	
	@Column(name="LOTE")
	private String lote;
	
	@Column(name="MEIA_ENTRADA")
	private Boolean meiaEntrada;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Boolean getMeiaEntrada() {
		return meiaEntrada;
	}

	public void setMeiaEntrada(Boolean meiaEntrada) {
		this.meiaEntrada = meiaEntrada;
	}
	
	

}
