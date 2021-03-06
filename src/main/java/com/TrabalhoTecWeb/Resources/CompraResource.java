package com.TrabalhoTecWeb.Resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.TrabalhoTecWeb.Model.Compra;
import com.TrabalhoTecWeb.Service.CompraService;

@RestController
@RequestMapping(value="/compras")
@CrossOrigin
public class CompraResource {
	
	@Autowired
	private CompraService compraService;

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> comprar(@Valid @RequestBody Compra compra){
		compra = compraService.salvar(compra);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(compra.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
}
