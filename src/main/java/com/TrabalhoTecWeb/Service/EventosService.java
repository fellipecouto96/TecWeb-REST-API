package com.TrabalhoTecWeb.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrabalhoTecWeb.Model.Evento;
import com.TrabalhoTecWeb.Repository.EventosRepository;
import com.TrabalhoTecWeb.Service.Exceptions.NenhumRegistroEncontradoException;
import com.TrabalhoTecWeb.Service.Exceptions.RegistroRepetidoException;

@Service
public class EventosService {

	@Autowired
	private EventosRepository eventosRepository;
	
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
		return eventosRepository.findByLocalAndHoraContaining(local, hora);
	}

	public List<Evento> listarPorNome(String nome) {
		return eventosRepository.findBynomeContaining(nome);
	}

}
