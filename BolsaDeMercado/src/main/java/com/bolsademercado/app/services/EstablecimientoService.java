package com.bolsademercado.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsademercado.app.models.Establecimiento;
import com.bolsademercado.app.repositories.EstablecimientoRepository;

@Service
public class EstablecimientoService {

	@Autowired
	private EstablecimientoRepository establecimientoRepository;
	
	public Establecimiento dataByEstablecimientoId(Long establecimientoId) {
		return establecimientoRepository.dataByEstablecimientoId(establecimientoId);
	}

	public Iterable<Object> listAllEstablecimientosByPersona(Long personaId) {
		return establecimientoRepository.listAllEstablecimientosByPersona(personaId);
	}

}
