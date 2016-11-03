package com.TrabalhoTecWeb.Resources;

import java.net.URI;
import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.TrabalhoTecWeb.Model.Evento;
import com.TrabalhoTecWeb.Service.EventosService;

@RestController
@RequestMapping(value="/eventos")
public class EventoResources {
	
	@Autowired
	private EventosService eventosService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Evento>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(eventosService.listar());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Evento evento){
		evento = eventosService.salvar(evento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(evento.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Integer id){
		eventosService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{id}")
	public ResponseEntity<Void> alterar(@Valid @RequestBody Evento evento, @PathVariable("id") Integer id){
		evento.setId(id);
		eventosService.alterar(evento);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET,params={"nome"})
	public ResponseEntity<List<Evento>> listarPorNome(@RequestParam(value = "nome") String nome){
		List<Evento> evento = eventosService.listarPorNome(nome);
		return ResponseEntity.status(HttpStatus.OK).body(evento);
	}
	
	@RequestMapping(method=RequestMethod.GET,params={"data"})
	public ResponseEntity<List<Evento>> listarPorData(@RequestParam(value = "data") Date data){
		List<Evento> evento = eventosService.listarPorData(data);
		return ResponseEntity.status(HttpStatus.OK).body(evento);
	}

}
