package com.bolsademercado.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "medidas")
public class Medida {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long medidaId;

	private String nombre;
	private String simbolo;
	private int status;

	public Long getMedidaId() {
		return medidaId;
	}

	public void setMedidaId(Long medidaId) {
		this.medidaId = medidaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
