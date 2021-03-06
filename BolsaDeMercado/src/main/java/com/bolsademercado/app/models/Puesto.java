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
		@NamedQuery(query = "FROM Puesto p WHERE puestoId = :puestoId", name = "Puesto.dataById"),
		@NamedQuery(query = "FROM Puesto p inner join Establecimiento e on p.establecimientoId = e.establecimientoId AND p.establecimientoId = :establecimientoId AND ( p.duenoId = :personaId OR p.vendedorId = :personaId)", name = "Puesto.listAllPuestosByEstablecimiento") })
@Table(name = "puestos")
public class Puesto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long puestoId;

	private Long establecimientoId;
	private Long duenoId;
	private Long vendedorId;
	private int status;

	public Long getPuestoId() {
		return puestoId;
	}

	public void setPuestoId(Long puestoId) {
		this.puestoId = puestoId;
	}

	public Long getEstablecimientoId() {
		return establecimientoId;
	}

	public void setEstablecimientoId(Long establecimientoId) {
		this.establecimientoId = establecimientoId;
	}

	public Long getDuenoId() {
		return duenoId;
	}

	public void setDuenoId(Long duenoId) {
		this.duenoId = duenoId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getVendedorId() {
		return vendedorId;
	}

	public void setVendedorId(Long vendedorId) {
		this.vendedorId = vendedorId;
	}

}
