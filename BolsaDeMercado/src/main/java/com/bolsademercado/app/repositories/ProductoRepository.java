package com.bolsademercado.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bolsademercado.app.models.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
	
	Iterable<Producto> listAllProductosByCategory(@Param("categoriaId") Long categoriaId);

}
