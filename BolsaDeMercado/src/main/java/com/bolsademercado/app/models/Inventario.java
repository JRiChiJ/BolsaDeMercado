package com.bolsademercado.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventarios")
public class Inventario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long inventarioId;
	private Long medidaId;
	private Long detalleId;
	private Double cantidad;

	public Long getInventarioId() {
		return inventarioId;
	}

	public void setInventarioId(Long inventarioId) {
		this.inventarioId = inventarioId;
	}

	public Long getMedidaId() {
		return medidaId;
	}

	public void setMedidaId(Long medidaId) {
		this.medidaId = medidaId;
	}

	public Long getDetalleId() {
		return detalleId;
	}

	public void setDetalleId(Long detalleId) {
		this.detalleId = detalleId;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
}
