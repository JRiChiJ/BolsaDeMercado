package com.bolsademercado.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsademercado.app.models.Producto;
import com.bolsademercado.app.repositories.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	ProductoRepository productoRepository;
	
	public Iterable<Producto> listAllProductosByCategory(Long categoriaId) {
		return productoRepository.listAllProductosByCategory(categoriaId);
	}
	
}
