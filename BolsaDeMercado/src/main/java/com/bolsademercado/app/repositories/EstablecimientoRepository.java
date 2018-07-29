package com.bolsademercado.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bolsademercado.app.models.Establecimiento;

public interface EstablecimientoRepository extends CrudRepository<Establecimiento, Long> {
	Iterable<Object> listAllEstablecimientosByPersona(Long personaId);
}