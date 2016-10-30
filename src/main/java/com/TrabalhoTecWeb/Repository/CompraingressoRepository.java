package com.TrabalhoTecWeb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.TrabalhoTecWeb.Model.CompraIngresso;

public interface CompraingressoRepository extends JpaRepository<CompraIngresso, Integer> {
	
	@Query("SELECT ci FROM CompraIngresso ci "
			+ "inner join ci.ingresso i "
			+ "inner join i.evento e "
			+ "where e.id =:codEvento")
	public List<CompraIngresso> gerarDadosRelatorioEvento(@Param("codEvento") Integer codEvento);
	
	@Query("SELECT ci FROM CompraIngresso ci "
			+ "inner join ci.compra c "
			+ "inner join c.cliente cl "
			+ "where cl.id =:codCliente")
	public List<CompraIngresso> gerarDadosRelatorioCliente(@Param("codCliente") Integer codCliente);
	

}
