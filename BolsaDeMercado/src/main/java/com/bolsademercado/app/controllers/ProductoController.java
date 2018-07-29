package com.bolsademercado.app.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolsademercado.app.models.DetallePuestoProducto;
import com.bolsademercado.app.models.Historial;
import com.bolsademercado.app.models.Inventario;
import com.bolsademercado.app.models.Producto;
import com.bolsademercado.app.services.DetallePuestoProductoService;
import com.bolsademercado.app.services.HistorialService;
import com.bolsademercado.app.services.InventarioService;
import com.bolsademercado.app.services.ProductoService;

@Controller
@RequestMapping(value = "/productos")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@Autowired
	DetallePuestoProductoService detallePuestoProductoService;
	
	@Autowired
	InventarioService inventarioService;
	
	@Autowired
	HistorialService historialService;

	@RequestMapping(value = "listProductosByCategoriaToAdd", method = RequestMethod.GET)
	public String listProductosByCategoriaToAdd(Model model,
			@RequestParam(name = "categoriaId", required = true, defaultValue = "0") Long categoriaId,
			@RequestParam(name = "puestoId", required = true, defaultValue = "0") Long puestoId) {

		Iterable<Producto> productList = productoService.listAllProductosByCategory(categoriaId);

		model.addAttribute("productList", productList);
		model.addAttribute("categoriaId", categoriaId);
		model.addAttribute("puestoId", puestoId);

		return "vendedor/listProductosByCategoriaToAdd";
	}

	@RequestMapping(value = "addComercialProductoToPuesto", method = RequestMethod.GET)
	public String addComercialProductoToPuesto(Model model,
			@RequestParam(name = "categoriaId", required = true, defaultValue = "0") Long categoriaId,
			@RequestParam(name = "puestoId", required = true, defaultValue = "0") Long puestoId,
			@RequestParam(name = "productoId", required = true, defaultValue = "0") Long productoId) {

		model.addAttribute("categoriaId", categoriaId);
		model.addAttribute("puestoId", puestoId);
		model.addAttribute("productoId", productoId);
		return "vendedor/addComercialProductoToPuesto";
	}

	@RequestMapping(value = "submitAddComercialProductoToPuesto", method = RequestMethod.POST)
	public String submitAddComercialProductoToPuesto(Model model,
			@RequestParam(name = "categoriaId", required = true, defaultValue = "0") Long categoriaId,
			@RequestParam(name = "puestoId", required = true, defaultValue = "0") Long puestoId,
			@RequestParam(name = "productoId", required = true, defaultValue = "0") Long productoId,
			@RequestParam(name = "medidaId", required = true, defaultValue = "0") Long medidaId,
			@RequestParam(name = "cantidad", required = true, defaultValue = "0") Double cantidad,
			@RequestParam(name = "precio", required = true, defaultValue = "0") Double precio) {
		
			DetallePuestoProducto detallePuestoProducto = new DetallePuestoProducto();
			detallePuestoProducto.setProductoId(productoId);
			detallePuestoProducto.setPuestoId(puestoId);
			DetallePuestoProducto record = detallePuestoProductoService.addDetallePuestoProducto(detallePuestoProducto);
			
			Inventario inventario = new Inventario();
			inventario.setCantidad(cantidad);
			inventario.setMedidaId(medidaId);
			inventario.setDetalleId(record.getDetalleId());
			inventarioService.addInventario(inventario);
			
			Historial historial = new Historial();
			historial.setDetalleId(record.getDetalleId());
			historial.setMedidaId(medidaId);
			historial.setPrecio(precio);
			historial.setFecha(LocalDateTime.now());
			historialService.addHistorial(historial);
			

		return "redirect:/productos/addComercialProductoToPuesto?categoriaId="+categoriaId+"&puestoId="+puestoId+"&productoId="+productoId;
	}
}
