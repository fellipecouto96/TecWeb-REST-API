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
import com.TrabalhoTecWeb.Service.ClientesService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResources {
	
	@Autowired
	private ClientesService clientesService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(clientesService.listar());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Cliente cliente){
		cliente = clientesService.salvar(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(cliente.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Integer id){
		clientesService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(method=RequestMethod.PUT,value="/{id}")
	public ResponseEntity<Void> alterar(@Valid @RequestBody Cliente cliente, @PathVariable("id") Integer id){
		cliente.setId(id);
		clientesService.alterar(cliente);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET,params={"cpf"})
	public ResponseEntity<Cliente> pesquisarPorCpf(@RequestParam(value = "cpf") String cpf){
		Cliente cliente = clientesService.obterPorCpf(cpf);
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}
	@RequestMapping(method=RequestMethod.GET,params={"nome"})
	public ResponseEntity<List<Cliente>> pesquisarPorNome(@RequestParam(value = "nome") String nome){
		List<Cliente> clientes = clientesService.listarPorNome(nome);
		return ResponseEntity.status(HttpStatus.OK).body(clientes);
	}
	
	
}
