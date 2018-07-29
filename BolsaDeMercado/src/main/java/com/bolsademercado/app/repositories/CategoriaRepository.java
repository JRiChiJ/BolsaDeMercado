package com.bolsademercado.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bolsademercado.app.models.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	Iterable<Categoria> listarCategorias(@Param("nombre") String nombre);
}
