package com.TrabalhoTecWeb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TrabalhoTecWeb.Model.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Integer> {
}
