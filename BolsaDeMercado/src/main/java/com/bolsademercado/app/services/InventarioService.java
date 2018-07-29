package com.bolsademercado.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsademercado.app.models.Inventario;
import com.bolsademercado.app.repositories.InventarioRepository;

@Service
public class InventarioService {

	@Autowired
	InventarioRepository inventarioRepository;
	
	public Inventario addInventario(Inventario inventario) {
		return inventarioRepository.save(inventario);
	}
	
}
