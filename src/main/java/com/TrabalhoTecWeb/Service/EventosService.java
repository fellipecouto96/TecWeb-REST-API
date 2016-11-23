package com.TrabalhoTecWeb.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import com.TrabalhoTecWeb.Model.Evento;
import com.TrabalhoTecWeb.Repository.EventosRepository;
import com.TrabalhoTecWeb.Service.Exceptions.ApplicationException;
import com.TrabalhoTecWeb.Service.Exceptions.NenhumRegistroEncontradoException;
import com.TrabalhoTecWeb.Service.Exceptions.RegistroRepetidoException;

@Service
public class EventosService {

	@Autowired
	private EventosRepository eventosRepository;
	
	@Autowired
	private IngressoService ingressoService;
	
	public List<Evento> listar() {
		return eventosRepository.findAll();
	}

	public Evento salvar(Evento evento) {
		evento.setId(null);
		return eventosRepository.save(evento);
	}

	public void alterar(Evento evento) {
		validarExistenciaEvento(evento.getId());
		eventosRepository.save(evento);
		
	}
	
	public void deletar(Integer id) {
		validarExistenciaEvento(id);
		System.out.println(ingressoService.listarPorCodEvento(id).isEmpty());
		if(!ingressoService.listarPorCodEvento(id).isEmpty()){
			throw new ApplicationException("Não é possível deletar o evento pois existem ingressos vinculados");
		}
		eventosRepository.delete(id);
		
	}

	private void validarExistenciaEvento(Integer id) {
		if(eventosRepository.findOne(id) == null){
			throw new NenhumRegistroEncontradoException("O código informado não foi localizado.");
		}
	}
	
	public List<Evento> obterPorNome(String nome) {
		return eventosRepository.findBynomeContaining(nome);
	}

	
	public List<Evento> obterPorLocalEHora(String local, Time hora) {
		return eventosRepository.findByLocalAndHora(local, hora);
	}

	public List<Evento> listarPorNome(String nome) {
		return eventosRepository.findBynomeContaining(nome);
	}
	
	public List<Evento> listarPorData(Date data) {
		return eventosRepository.findByData(data);
	}

}
