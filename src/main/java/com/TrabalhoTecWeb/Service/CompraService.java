package com.TrabalhoTecWeb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrabalhoTecWeb.Model.Compra;
import com.TrabalhoTecWeb.Model.Ingresso;
import com.TrabalhoTecWeb.Repository.CompraRepository;
import com.TrabalhoTecWeb.Service.Exceptions.CampoObrigatorioNaoPreenchidoException;

@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private IngressoService ingressoService;
	
	public Compra salvar(Compra compra){
		validarIngressos(compra.getListaIngresso());
		
		return compra;
	}
	
	private void validarIngressos(List<Ingresso> lista){
		for (Ingresso ingresso : lista) {
			//valida se preencheu o id e a quantidade no ingresso
			validarCamposNecessariosIngresso(ingresso);
			
			//valida se o ingresso existe
			ingressoService.validarIngressoExistente(ingresso.getId());
			
			//obtem o ingresso da base para verificar se a quantidade solicitada na
			//requisição ainda é valida para aquele ingresso
			Ingresso ingressoBase = ingressoService.obter(ingresso.getId());
			
			//TODO CONTINUE FROM HERE
		}
	}

	private void validarCamposNecessariosIngresso(Ingresso ingresso) {
		if(ingresso.getId() == null){
			throw new CampoObrigatorioNaoPreenchidoException("É necessário informar o codigo do ingresso");
		}
		if(ingresso.getQuantidade() == null){
			throw new CampoObrigatorioNaoPreenchidoException("É necessário informar a quantidade de ingressos que se deseja comprar");
		}
		
		
	}
	
	
}
