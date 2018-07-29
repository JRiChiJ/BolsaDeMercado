package com.bolsademercado.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsademercado.app.models.Categoria;
import com.bolsademercado.app.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria dataById(Long categoriaId) {
		return categoriaRepository.dataById(categoriaId);
	}

	public Iterable<Categoria> listarCategorias() {
		return categoriaRepository.findAll();
	}

	public Iterable<Object> listCategoriasByPersonaPuestoWithProducts(Long puestoId) {
		return categoriaRepository.listCategoriasByPersonaPuestoWithProducts(puestoId);
	}

}
