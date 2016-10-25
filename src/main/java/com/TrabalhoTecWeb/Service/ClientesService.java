package com.TrabalhoTecWeb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrabalhoTecWeb.Model.Cliente;
import com.TrabalhoTecWeb.Repository.ClientesRepository;
import com.TrabalhoTecWeb.Service.Exceptions.NenhumRegistroEncontradoException;
import com.TrabalhoTecWeb.Service.Exceptions.RegistroRepetidoException;

@Service
public class ClientesService {

	@Autowired
	private ClientesRepository clientesRepository;
	
	public List<Cliente> listar() {
		return clientesRepository.findAll();
	}

	public Cliente salvar(Cliente cliente) {
		//verifica se já existe Cliente com o cpf informado
		if(clientesRepository.findByCpf(cliente.getCpf()) != null){
			throw new RegistroRepetidoException("Já existe um cadastro para este CPF.");
		}
		cliente.setId(null);
		return clientesRepository.save(cliente);
	}

	public void deletar(Integer id) {
		validarExistenciaCliente(id);
		clientesRepository.delete(id);
		
	}

	private void validarExistenciaCliente(Integer id) {
		if(clientesRepository.findOne(id) == null){
			throw new NenhumRegistroEncontradoException("O código informado não foi localizado.");
		}
	}

	public Cliente obterPorCpf(String cpf) {
		return clientesRepository.findByCpf(cpf);
	}

	public List<Cliente> listarPorNome(String nome) {
		return clientesRepository.findBynomeContaining(nome);
	}

	public void alterar(Cliente cliente) {
		System.out.println(cliente.getId());
		validarExistenciaCliente(cliente.getId());
		clientesRepository.save(cliente);
		
	}

}
