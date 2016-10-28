package com.TrabalhoTecWeb.Model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="compra",schema="tecweb")
public class Compra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COMPRA")
	private Integer id;
	
	@Column(name="VALOR_COMPRA")
	private BigDecimal valorCompra;
	
	@Column(name="DATA_HORA_COMPRA")
	private Date dataHoraCompra;
	
	@Column(name="TIPO_PAGAMENTO")
	@NotBlank(message="O campo tipo pagamento deve ser informado")
	private String tipoPagamento;
	
	@Transient
	@NotEmpty(message="Devem ser informados os ingressos")
	private List<Ingresso> listaIngresso;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	@NotNull(message="O cliente deve ser informado")
	private Cliente cliente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Date getDataHoraCompra() {
		return dataHoraCompra;
	}

	public void setDataHoraCompra(Date dataHoraCompra) {
		this.dataHoraCompra = dataHoraCompra;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Ingresso> getListaIngresso() {
		return listaIngresso;
	}

	public void setListaIngresso(List<Ingresso> listaIngresso) {
		this.listaIngresso = listaIngresso;
	}
	
	

}
