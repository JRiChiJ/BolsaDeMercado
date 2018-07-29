package com.bolsademercado.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_puesto_producto")
public class DetallePuestoProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long detalleId;

	private Long puestoId;
	private Long productoId;
	
	public Long getDetalleId() {
		return detalleId;
	}
	public void setDetalleId(Long detalleId) {
		this.detalleId = detalleId;
	}
	public Long getPuestoId() {
		return puestoId;
	}
	public void setPuestoId(Long puestoId) {
		this.puestoId = puestoId;
	}
	public Long getProductoId() {
		return productoId;
	}
	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	
	
}
