package com.TrabalhoTecWeb.Service.Exceptions;

public class NenhumRegistroEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 742329123919863956L;

	public NenhumRegistroEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public NenhumRegistroEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
