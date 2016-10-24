package com.TrabalhoTecWeb.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
}
