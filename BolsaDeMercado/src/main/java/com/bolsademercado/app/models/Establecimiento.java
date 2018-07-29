package com.bolsademercado.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "establecimientos")
public class Establecimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long establecimientoId;

	public Long getEstablecimientoId() {
		return establecimientoId;
	}

	public void setEstablecimientoId(Long establecimientoId) {
		this.establecimientoId = establecimientoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	private String nombre;
	private int status;

}
