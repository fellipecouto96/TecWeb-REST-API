package com.TrabalhoTecWeb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TrabalhoTecWeb.Model.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Integer> {
	
	Cliente findByCpf(String cpf);
	
	List<Cliente> findBynomeContaining(String nome);
}
