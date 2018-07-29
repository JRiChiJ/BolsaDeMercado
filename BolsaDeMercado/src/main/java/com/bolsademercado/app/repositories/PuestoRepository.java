package com.bolsademercado.app.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bolsademercado.app.models.Puesto;

public interface PuestoRepository extends CrudRepository <Puesto,Long>{
	Iterable<Object> listAllPuestosByEstablecimiento(@Param("establecimientoId") Long establecimientoId,@Param("personaId") Long personaId);
}
