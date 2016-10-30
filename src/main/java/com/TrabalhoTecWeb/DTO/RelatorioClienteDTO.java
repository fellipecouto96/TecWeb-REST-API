package com.TrabalhoTecWeb.DTO;

import java.io.Serializable;
import java.util.List;

public class RelatorioClienteDTO implements Serializable {

	private static final long serialVersionUID = -5537241820663944311L;
	private String nomeEvento;
	private String dataEvento;
	private String horaEvento;
	private String cepEvento;
	private String logradouroEvento;
	private Integer numeroEvento;
	private String bairroEvento;
	private String cidadeEvento;
	private String estadoEvento;
	private String complementoEvento;
	private List<ClienteIngressoRelatorioClienteDTO> listaClienteIngresso;
	
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public String getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}
	public String getHoraEvento() {
		return horaEvento;
	}
	public void setHoraEvento(String horaEvento) {
		this.horaEvento = horaEvento;
	}
	public String getCepEvento() {
		return cepEvento;
	}
	public void setCepEvento(String cepEvento) {
		this.cepEvento = cepEvento;
	}
	public String getLogradouroEvento() {
		return logradouroEvento;
	}
	public void setLogradouroEvento(String logradouroEvento) {
		this.logradouroEvento = logradouroEvento;
	}
	public Integer getNumeroEvento() {
		return numeroEvento;
	}
	public void setNumeroEvento(Integer numeroEvento) {
		this.numeroEvento = numeroEvento;
	}
	public String getBairroEvento() {
		return bairroEvento;
	}
	public void setBairroEvento(String bairroEvento) {
		this.bairroEvento = bairroEvento;
	}
	public String getCidadeEvento() {
		return cidadeEvento;
	}
	public void setCidadeEvento(String cidadeEvento) {
		this.cidadeEvento = cidadeEvento;
	}
	public String getEstadoEvento() {
		return estadoEvento;
	}
	public void setEstadoEvento(String estadoEvento) {
		this.estadoEvento = estadoEvento;
	}
	public String getComplementoEvento() {
		return complementoEvento;
	}
	public void setComplementoEvento(String complementoEvento) {
		this.complementoEvento = complementoEvento;
	}
	public List<ClienteIngressoRelatorioClienteDTO> getListaClienteIngresso() {
		return listaClienteIngresso;
	}
	public void setListaClienteIngresso(List<ClienteIngressoRelatorioClienteDTO> listaClienteIngresso) {
		this.listaClienteIngresso = listaClienteIngresso;
	}
	

}
