package com.bolsademercado.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsademercado.app.models.Historial;
import com.bolsademercado.app.repositories.HistorialRepository;

@Service
public class HistorialService {

	@Autowired
	HistorialRepository historialRepository;
	
	public Historial addHistorial(Historial historial) {
		return historialRepository.save(historial);
	}
	
}
