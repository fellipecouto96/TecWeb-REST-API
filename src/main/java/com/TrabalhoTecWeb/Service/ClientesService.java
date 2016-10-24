package com.TrabalhoTecWeb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrabalhoTecWeb.Model.Cliente;
import com.TrabalhoTecWeb.Repository.ClientesRepository;

@Service
public class ClientesService {

	@Autowired
	private ClientesRepository clientesRepository;
	
	public List<Cliente> listar() {
		return clientesRepository.findAll();
	}

}
