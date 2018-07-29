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
	@NamedQuery(query = "SELECT SUM(inventario.cantidad), categorias.nombre AS categoria, productos.nombre AS productoId, medidas.nombre AS medida, medidas.simbolo AS simbolo, AVG(historiales.precio) AS promedioPrecio FROM DetallePuestoProducto AS dpp LEFT JOIN Historial AS historiales ON historiales.detalleId = dpp.detalleId LEFT JOIN Producto AS productos ON productos.productoId = dpp.productoId LEFT JOIN Medida AS medidas ON medidas.medidaId = historiales.medidaId LEFT JOIN Categoria AS categorias ON categorias.categoriaId = productos.categoriaId LEFT JOIN Inventario AS inventario ON inventario.detalleId = dpp.detalleId GROUP BY historiales.medidaId, dpp.productoId", name = "Producto.listAllProductosForVisitors"),
	@NamedQuery(query = "FROM Producto p WHERE p.productoId = :productoId", name = "Producto.dataById"),
	@NamedQuery(query = "FROM Producto p WHERE p.categoriaId = :categoriaId", name = "Producto.listAllProductosByCategory") })
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productoId;

	private Long categoriaId;
	private String nombre;
	private int status;

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
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

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

}
