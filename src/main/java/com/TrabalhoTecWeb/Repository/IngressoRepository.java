package com.TrabalhoTecWeb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.TrabalhoTecWeb.Model.Ingresso;

public interface IngressoRepository extends JpaRepository<Ingresso, Integer> {
	
	@Query("SELECT i FROM Ingresso i inner join i.evento e WHERE e.id =:codEvento")
    public List<Ingresso> listarPorCodEvento(@Param("codEvento") Integer codEvento);

	@Query("SELECT i FROM Ingresso i inner join i.evento e WHERE e.id =:codEvento and i.id =:idIngresso")
	public List<Ingresso> listarPorCodEventoCodIngresso(@Param("codEvento")Integer codEvento, @Param("idIngresso")Integer codIngresso);

}
