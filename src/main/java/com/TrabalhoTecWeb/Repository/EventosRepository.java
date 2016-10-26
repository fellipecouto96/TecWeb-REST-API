package com.TrabalhoTecWeb.Repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TrabalhoTecWeb.Model.Evento;

public interface EventosRepository extends JpaRepository<Evento, Integer> {
	
	Evento findByDataAndLocalAndHoraContaining(String local, Time hora, Date data);
	
	List<Evento> findByLocalAndHoraContaining(String local, Time hora);
	
	List<Evento> findBynomeContaining(String nome);
	
	List<Evento> findByData(Date data);

}
