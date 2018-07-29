package com.bolsademercado.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
		@NamedQuery(query = "SELECT DISTINCT e.establecimientoId, e.nombre, e.direccion FROM Establecimiento e LEFT JOIN Puesto p ON p.establecimientoId = e.establecimientoId WHERE p.duenoId = :personaId OR p.vendedorId = :personaId AND p.establecimientoId = e.establecimientoId", name = "Establecimiento.listAllEstablecimientosByPersona"),
		@NamedQuery(query = "FROM Establecimiento e WHERE e.establecimientoId = :establecimientoId", name = "Establecimiento.dataByEstablecimientoId")
		})
@Table(name = "establecimientos")
public class Establecimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long establecimientoId;

	private String nombre;
	private String direccion;
	private int status;

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

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
}
