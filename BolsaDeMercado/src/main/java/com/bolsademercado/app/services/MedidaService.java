package com.bolsademercado.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsademercado.app.models.Medida;
import com.bolsademercado.app.repositories.MedidaRepository;

@Service
public class MedidaService {

	@Autowired
	MedidaRepository medidaRepository;
	
	public Iterable<Medida> listAll() {
		return medidaRepository.findAll();
	}
	
}
