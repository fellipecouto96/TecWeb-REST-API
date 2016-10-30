package com.TrabalhoTecWeb.DTO;

import java.math.BigDecimal;

public class ClienteIngressoRelatorioDTO {
	private Integer idCliente;
	private String nomeCliente;
	private String telefoneCliente;
	private String emailCliente;
	private Integer codIngresso;
	private String setorIngresso;
	private String loteIngresso;
	private Boolean meiaEntrada;
	private Integer quantidadeIngressos;
	private BigDecimal valorIngresso;
	public Integer getCodIngresso() {
		return codIngresso;
	}
	public void setCodIngresso(Integer codIngresso) {
		this.codIngresso = codIngresso;
	}
	public String getSetorIngresso() {
		return setorIngresso;
	}
	public void setSetorIngresso(String setorIngresso) {
		this.setorIngresso = setorIngresso;
	}
	public String getLoteIngresso() {
		return loteIngresso;
	}
	public void setLoteIngresso(String loteIngresso) {
		this.loteIngresso = loteIngresso;
	}
	public Boolean getMeiaEntrada() {
		return meiaEntrada;
	}
	public void setMeiaEntrada(Boolean meiaEntrada) {
		this.meiaEntrada = meiaEntrada;
	}
	public BigDecimal getValorIngresso() {
		return valorIngresso;
	}
	public void setValorIngresso(BigDecimal valorIngresso) {
		this.valorIngresso = valorIngresso;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public Integer getQuantidadeIngressos() {
		return quantidadeIngressos;
	}
	public void setQuantidadeIngressos(Integer quantidadeIngressos) {
		this.quantidadeIngressos = quantidadeIngressos;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public String getTelefoneCliente() {
		return telefoneCliente;
	}
	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	
	
}
