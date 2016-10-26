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
		//verifica se já existe Cliente com o cpf informado
		if(eventosRepository.findByDataAndLocalAndHoraContaining(evento.getLocal().getLogradouro(), evento.getHora(), evento.getData()) != null){
			throw new RegistroRepetidoException("Já existe um cadastro para esta data, local e horario.");
		}
		evento.setId(null);
		return eventosRepository.save(evento);
	}

	public void alterar(Evento evento) {
		System.out.println(evento.getId());
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

	public Evento obterPorDataLocalEHora(String local, Time hora, Date data) {
		return eventosRepository.findByDataAndLocalAndHoraContaining(local, hora, data);
	}
	
	public List<Evento> obterPorLocalEHora(String local, Time hora) {
		return eventosRepository.findByLocalAndHoraContaining(local, hora);
	}

	public List<Evento> listarPorNome(String nome) {
		return eventosRepository.findBynomeContaining(nome);
	}

}
