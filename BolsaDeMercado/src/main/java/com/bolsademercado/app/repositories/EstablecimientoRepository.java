package com.bolsademercado.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bolsademercado.app.models.Establecimiento;

public interface EstablecimientoRepository extends CrudRepository<Establecimiento, Long> {
	Iterable<Object> listAllEstablecimientosByPersona(@Param("personaId") Long personaId);
}