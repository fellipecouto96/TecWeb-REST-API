package com.TrabalhoTecWeb.Resources;

import java.net.URI;
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

import com.TrabalhoTecWeb.Model.Cliente;
import com.TrabalhoTecWeb.Model.Ingresso;
import com.TrabalhoTecWeb.Service.IngressoService;

@RestController
@RequestMapping(value="/ingressos")
public class IngressoResource {

	@Autowired
	private IngressoService ingressoService;
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<Ingresso> obterPorId(@PathVariable("id") Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(ingressoService.obter(id));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Ingresso ingresso){
		ingresso = ingressoService.salvar(ingresso);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(ingresso.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.GET, params={"evento"})
	public ResponseEntity<List<Ingresso>> pesquisarPorEvento(@RequestParam(value="evento") Integer codEvento){
		List<Ingresso> ingressos = ingressoService.listarPorCodEvento(codEvento);
		return ResponseEntity.status(HttpStatus.OK).body(ingressos);
	}
	
	@RequestMapping(method = RequestMethod.GET, params={"evento","ingresso"})
	public ResponseEntity<List<Ingresso>> pesquisarPorEventoIngresso(@RequestParam(value="evento") Integer codEvento,@RequestParam(value="ingresso") Integer codIngresso){
		List<Ingresso> ingressos = ingressoService.listarPorCodEventoCodIngresso(codEvento,codIngresso);
		return ResponseEntity.status(HttpStatus.OK).body(ingressos);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{id}")
	public ResponseEntity<Void> alterar(@Valid @RequestBody Ingresso ingresso, @PathVariable("id") Integer id){
		ingresso.setId(id);
		ingressoService.alterar(ingresso);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Integer id){
		ingressoService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
}
