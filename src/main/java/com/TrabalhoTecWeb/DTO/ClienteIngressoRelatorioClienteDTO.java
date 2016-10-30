package com.TrabalhoTecWeb.DTO;

import java.math.BigDecimal;

public class ClienteIngressoRelatorioClienteDTO {
	
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
	public Integer getQuantidadeIngressos() {
		return quantidadeIngressos;
	}
	public void setQuantidadeIngressos(Integer quantidadeIngressos) {
		this.quantidadeIngressos = quantidadeIngressos;
	}

	
	
}
