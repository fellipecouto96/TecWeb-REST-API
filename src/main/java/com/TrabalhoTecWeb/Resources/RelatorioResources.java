package com.TrabalhoTecWeb.Resources;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TrabalhoTecWeb.DTO.RelatorioClienteDTO;
import com.TrabalhoTecWeb.DTO.RelatorioEventoDTO;
import com.TrabalhoTecWeb.Service.RelatorioService;

@RestController
@RequestMapping(value="/relatorio")
public class RelatorioResources {
	
	@Autowired
	RelatorioService relatorioService;
	
	@RequestMapping(params="evento",method=RequestMethod.GET)
	public ResponseEntity<RelatorioEventoDTO> imprimirRelatorioEvento(@RequestParam(value="evento") Integer codEvento){
		
		return ResponseEntity.status(HttpStatus.OK).body(relatorioService.gerarDadosRelatorio(codEvento));
	}
	@RequestMapping(params="cliente",method=RequestMethod.GET)
	public ResponseEntity<Collection<RelatorioClienteDTO>> imprimirRelatorioCliente(@RequestParam(value="cliente") Integer codCliente){
		
		return ResponseEntity.status(HttpStatus.OK).body(relatorioService.gerarDadosRelatorioCliente(codCliente));
	}

}
