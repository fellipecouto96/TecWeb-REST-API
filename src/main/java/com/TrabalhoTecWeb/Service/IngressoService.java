package com.TrabalhoTecWeb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrabalhoTecWeb.Model.Cliente;
import com.TrabalhoTecWeb.Model.Evento;
import com.TrabalhoTecWeb.Model.Ingresso;
import com.TrabalhoTecWeb.Repository.EventosRepository;
import com.TrabalhoTecWeb.Repository.IngressoRepository;
import com.TrabalhoTecWeb.Service.Exceptions.NenhumRegistroEncontradoException;

@Service
public class IngressoService {

	@Autowired
	IngressoRepository ingressoRepository;
	@Autowired
	EventosRepository eventosRepository;
	
	public List<Ingresso> listar(){
		return ingressoRepository.findAll();
	}

	public Ingresso obter(Integer id) {
		return ingressoRepository.findOne(id);
	}

	public Ingresso salvar(Ingresso ingresso) {
		validarEventoExistente(ingresso);
		ingresso.setId(null);
		return ingressoRepository.save(ingresso);
	}

	private void validarEventoExistente(Ingresso ingresso) {
		if(ingresso.getEvento().getId() == null){
			throw new NenhumRegistroEncontradoException("O evento não foi localizado");
		}
		Evento evento = eventosRepository.findOne(ingresso.getEvento().getId());
		if(evento == null){
			throw new NenhumRegistroEncontradoException("O evento não foi localizado");
		}else{
			ingresso.setEvento(evento);
		}
	}

	public List<Ingresso> listarPorCodEvento(Integer codEvento) {
		return ingressoRepository.listarPorCodEvento(codEvento);
	}

	public List<Ingresso> listarPorCodEventoCodIngresso(Integer codEvento, Integer codIngresso) {
		return ingressoRepository.listarPorCodEventoCodIngresso(codEvento,codIngresso);
	}
	public void alterar(Ingresso ingresso) {
		validarIngressoExistente(ingresso.getId());
		ingressoRepository.save(ingresso);
	}

	public void excluir(Integer id) {
		//TODO VALIDAR SE JÁ EXISTEM INGRESSOS VENDIDOS
		validarIngressoExistente(id);
		ingressoRepository.delete(id);
	}

	public void validarIngressoExistente(Integer id) {
		if(id == null){
			throw new NenhumRegistroEncontradoException("O Cadastro do ingresso informado não foi localizado.");
		}
		Ingresso ingresso = ingressoRepository.findOne(id);
		if(ingresso == null){
			throw new NenhumRegistroEncontradoException("O Cadastro do ingresso informado não foi localizado.");
		}
	}
	
}
