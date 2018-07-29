package com.bolsademercado.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsademercado.app.models.Categoria;
import com.bolsademercado.app.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Iterable<Categoria> listarCategorias(String nombre) {
		return categoriaRepository.listarCategorias(nombre);
	}
	
}
