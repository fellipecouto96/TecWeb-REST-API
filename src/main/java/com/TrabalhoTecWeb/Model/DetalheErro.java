package com.TrabalhoTecWeb.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DetalheErro {
	
	private String titulo;
	
	private Integer status;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Long timestamp;
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}