package com.TrabalhoTecWeb.Model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="ingresso",schema="tecweb")
public class Ingresso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_INGRESSO")
	private Integer id;
	
	@Column(name="VALOR")
	@NotNull(message="O campo valor deve ser informado")
	private BigDecimal valor;
	
	@Column(name="SETOR")
	@NotBlank(message="O campo setor deve ser informado")
	private String setor;
	
	@Column(name="LOTE")
	@NotBlank(message="O campo lote deve ser informado")
	private String lote;
	
	@Column(name="MEIA_ENTRADA")
	@NotNull(message="O campo meia entrada deve ser informado")
	private Boolean meiaEntrada;
	
	@Column(name="QUANTIDADE")
	@NotNull(message="O campo quantidade deve ser informado")
	private Integer quantidade;
	
	
	@ManyToOne
	@JoinColumn(name="ID_EVENTO")
	@NotNull(message="O código do evento deve ser informado")
	private Evento evento;

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

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
