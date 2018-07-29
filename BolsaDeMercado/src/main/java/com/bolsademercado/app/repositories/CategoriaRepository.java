package com.bolsademercado.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bolsademercado.app.models.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	
	Categoria dataById(@Param("categoriaId") Long categoriaId);
	
	Iterable<Object> listCategoriasByPersonaPuestoWithProducts(@Param("puestoId") Long puestoId);
}
