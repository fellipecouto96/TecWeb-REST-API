package com.TrabalhoTecWeb.Service.Exceptions;

public class RegistroRepetidoException extends RuntimeException {

	private static final long serialVersionUID = -6513852465241610273L;
	
	public RegistroRepetidoException(String mensagem) {
		super(mensagem);
	}
	
	public RegistroRepetidoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
