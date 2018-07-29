package com.bolsademercado.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsademercado.app.models.DetallePuestoProducto;
import com.bolsademercado.app.repositories.DetallePuestoProductoRepository;

@Service
public class DetallePuestoProductoService {

	@Autowired
	DetallePuestoProductoRepository detallePuestoProductoRepository;
	
	public DetallePuestoProducto addDetallePuestoProducto(DetallePuestoProducto detallePuestoProducto) {
		return detallePuestoProductoRepository.save(detallePuestoProducto);
	}
	
}
