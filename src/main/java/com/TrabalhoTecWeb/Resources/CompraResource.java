package com.TrabalhoTecWeb.Resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.TrabalhoTecWeb.Model.Compra;
import com.TrabalhoTecWeb.Service.CompraService;

@RestController
@RequestMapping(value="/compras")
public class CompraResource {
	
	@Autowired
	private CompraService compraService;

	@RequestMapping(method=RequestMethod.POST)
	public void comprar(@Valid @RequestBody Compra compra){
		compra = compraService.salvar(compra);
	}
	
	
}
