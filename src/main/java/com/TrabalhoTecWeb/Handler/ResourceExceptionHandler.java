package com.TrabalhoTecWeb.Handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.TrabalhoTecWeb.Model.DetalheErro;
import com.TrabalhoTecWeb.Service.Exceptions.ApplicationException;
import com.TrabalhoTecWeb.Service.Exceptions.CampoObrigatorioNaoPreenchidoException;
import com.TrabalhoTecWeb.Service.Exceptions.NenhumRegistroEncontradoException;
import com.TrabalhoTecWeb.Service.Exceptions.RegistroRepetidoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<DetalheErro>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,HttpServletRequest request){
		List<DetalheErro> listaErros = new ArrayList<>();
		List<FieldError> fieldError = e.getBindingResult().getFieldErrors();
		
		for (FieldError fe : fieldError) {
			DetalheErro erro = new DetalheErro();
			erro.setStatus(HttpStatus.BAD_REQUEST.value());
			erro.setTitulo(fe.getDefaultMessage());
			erro.setTimestamp(System.currentTimeMillis());
			listaErros.add(erro);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaErros);
	}
	@ExceptionHandler(RegistroRepetidoException.class)
	public ResponseEntity<DetalheErro> handleRegistroRepetidoException(RegistroRepetidoException e,HttpServletRequest request){
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(HttpStatus.CONFLICT.value());
		erro.setTitulo(e.getMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	@ExceptionHandler(CampoObrigatorioNaoPreenchidoException.class)
	public ResponseEntity<DetalheErro> handleCampoObrigatorioNaoPreenchidoException(CampoObrigatorioNaoPreenchidoException e,HttpServletRequest request){
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(HttpStatus.BAD_REQUEST.value());
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
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<DetalheErro> handleApplicationException(ApplicationException e,HttpServletRequest request){
		DetalheErro erro = new DetalheErro();
		erro.setStatus(HttpStatus.CONFLICT.value());
		erro.setTitulo(e.getMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

}
