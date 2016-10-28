package com.TrabalhoTecWeb.Service.Exceptions;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = -8215478288442223867L;
	
	public ApplicationException(String mensagem) {
		super(mensagem);
	}
	
	public ApplicationException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
