package com.bolsademercado.app.models;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "historial")
public class Historial {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long historialId;
	
	private Date fecha;
	private Long detalleId;
	private Long medidaId;
	private Double precio;
	
	public Long getHistorialId() {
		return historialId;
	}
	public void setHistorialId(Long historialId) {
		this.historialId = historialId;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
