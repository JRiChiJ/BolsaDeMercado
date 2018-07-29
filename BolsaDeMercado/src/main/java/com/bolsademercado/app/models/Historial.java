package com.bolsademercado.app.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "historiales")
public class Historial {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long historialId;

	private LocalDateTime fecha;
	private Long detalleId;
	private Long medidaId;
	private Double precio;

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Long getHistorialId() {
		return historialId;
	}

	public void setHistorialId(Long historialId) {
		this.historialId = historialId;
	}

	public Long getDetalleId() {
		return detalleId;
	}

	public void setDetalleId(Long detalleId) {
		this.detalleId = detalleId;
	}

	public Long getMedidaId() {
		return medidaId;
	}

	public void setMedidaId(Long medidaId) {
		this.medidaId = medidaId;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
