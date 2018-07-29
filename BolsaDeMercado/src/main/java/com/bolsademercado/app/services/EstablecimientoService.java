package com.bolsademercado.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsademercado.app.repositories.EstablecimientoRepository;

@Service
public class EstablecimientoService {
	
	@Autowired
	private EstablecimientoRepository establecimientoRepository;
	
	public Iterable<Object> listAllEstablecimientosByPersona(Long personaId) {
		return establecimientoRepository.listAllEstablecimientosByPersona(personaId);
	}

}
