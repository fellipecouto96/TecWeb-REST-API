package com.TrabalhoTecWeb.Service.Exceptions;

public class CampoObrigatorioNaoPreenchidoException extends RuntimeException {


	private static final long serialVersionUID = 5104490738284554839L;

	public CampoObrigatorioNaoPreenchidoException(String mensagem) {
		super(mensagem);
	}
	
	public CampoObrigatorioNaoPreenchidoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
