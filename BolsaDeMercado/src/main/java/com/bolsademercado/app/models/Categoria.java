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
		@NamedQuery(query = "FROM Categoria c WHERE c.categoriaId = :categoriaId", name = "Categoria.dataById"),
		@NamedQuery(query = "SELECT DISTINCT c.categoriaId, c.nombre FROM Categoria c LEFT JOIN Producto as p ON p.categoriaId = c.categoriaId LEFT JOIN DetallePuestoProducto AS dpp ON dpp.productoId = p.productoId LEFT JOIN Puesto AS pu ON pu.puestoId = dpp.puestoId WHERE pu.puestoId = :puestoId", name = "Categoria.listCategoriasByPersonaPuestoWithProducts") })
@Table(name = "categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoriaId;

	private String nombre;
	private int status;

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
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
