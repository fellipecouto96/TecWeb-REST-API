package com.TrabalhoTecWeb.Handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.TrabalhoTecWeb.Model.DetalheErro;
import com.TrabalhoTecWeb.Service.Exceptions.NenhumRegistroEncontradoException;
import com.TrabalhoTecWeb.Service.Exceptions.RegistroRepetidoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DetalheErro> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,HttpServletRequest request){
		
		FieldError fieldError = e.getBindingResult().getFieldError();
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(HttpStatus.BAD_REQUEST.value());
		erro.setTitulo(fieldError.getDefaultMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	@ExceptionHandler(RegistroRepetidoException.class)
	public ResponseEntity<DetalheErro> handleRegistroRepetidoException(RegistroRepetidoException e,HttpServletRequest request){
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(HttpStatus.CONFLICT.value());
		erro.setTitulo(e.getMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	@ExceptionHandler(NenhumRegistroEncontradoException.class)
	public ResponseEntity<DetalheErro> handleNenhumRegistroEncontradoException(NenhumRegistroEncontradoException e,HttpServletRequest request){
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(HttpStatus.NOT_FOUND.value());
		erro.setTitulo(e.getMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}
