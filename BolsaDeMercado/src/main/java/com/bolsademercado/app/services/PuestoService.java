package com.bolsademercado.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsademercado.app.repositories.PuestoRepository;

@Service
public class PuestoService {
	@Autowired
	private PuestoRepository puestoRepository;
	
	public Iterable<Object> listAllPuestosByEstablecimiento(Long establecimientoId,Long personaId) {
		return puestoRepository.listAllPuestosByEstablecimiento(establecimientoId,personaId);
	}
}
