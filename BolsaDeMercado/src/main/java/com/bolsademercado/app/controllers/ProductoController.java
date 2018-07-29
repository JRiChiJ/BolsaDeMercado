package com.bolsademercado.app.controllers;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bolsademercado.app.models.Categoria;
import com.bolsademercado.app.models.DetallePuestoProducto;
import com.bolsademercado.app.models.Historial;
import com.bolsademercado.app.models.Inventario;
import com.bolsademercado.app.models.Medida;
import com.bolsademercado.app.models.Producto;
import com.bolsademercado.app.models.Puesto;
import com.bolsademercado.app.services.CategoriaService;
import com.bolsademercado.app.services.DetallePuestoProductoService;
import com.bolsademercado.app.services.EstablecimientoService;
import com.bolsademercado.app.services.HistorialService;
import com.bolsademercado.app.services.InventarioService;
import com.bolsademercado.app.services.MedidaService;
import com.bolsademercado.app.services.ProductoService;
import com.bolsademercado.app.services.PuestoService;

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
	
	@Autowired
	PuestoService puestoService;
	
	@Autowired
	EstablecimientoService establecimientoService;
	
	@Autowired
	CategoriaService categoriaService;

	@Autowired
	MedidaService medidaService;
	
	@RequestMapping(value = "listProductosByCategoriaToAdd", method = RequestMethod.GET)
	public String listProductosByCategoriaToAdd(Model model,
			@RequestParam(name = "categoriaId", required = true, defaultValue = "0") Long categoriaId,
			@RequestParam(name = "puestoId", required = true, defaultValue = "0") Long puestoId) {

		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpSession httpSession = servletRequestAttributes.getRequest().getSession();
		
		if (httpSession.getAttribute("isLogged") != null) {
			Iterable<Producto> productList = productoService.listAllProductosByCategory(categoriaId);

			Puesto puestoData = puestoService.dataById(puestoId);
			Categoria categoriaData = categoriaService.dataById(categoriaId);
			
			model.addAttribute("categoriaData", categoriaData);
			model.addAttribute("productList", productList);
			model.addAttribute("categoriaId", categoriaId);
			model.addAttribute("puestoId", puestoId);
			model.addAttribute("puestoData", puestoData);	
			model.addAttribute("establecimientoData", establecimientoService.dataByEstablecimientoId(puestoData.getEstablecimientoId()));

			return "vendedor/listProductosByCategoriaToAdd";
		} else {
			return "redirect:/user/login";
		}
	}

	@RequestMapping(value = "addComercialProductoToPuesto", method = RequestMethod.GET)
	public String addComercialProductoToPuesto(Model model,
			@RequestParam(name = "categoriaId", required = true, defaultValue = "0") Long categoriaId,
			@RequestParam(name = "puestoId", required = true, defaultValue = "0") Long puestoId,
			@RequestParam(name = "productoId", required = true, defaultValue = "0") Long productoId) {
		
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpSession httpSession = servletRequestAttributes.getRequest().getSession();
		
		if (httpSession.getAttribute("isLogged") != null) {
			model.addAttribute("categoriaId", categoriaId);
			model.addAttribute("puestoId", puestoId);
			model.addAttribute("productoId", productoId);
			
			Puesto puestoData = puestoService.dataById(puestoId);
			Categoria categoriaData = categoriaService.dataById(categoriaId);
			Producto productoData = productoService.dataById(productoId);
			Iterable<Medida> medidaList = medidaService.listAll();
			
			model.addAttribute("medidaList", medidaList);
			model.addAttribute("productoData", productoData);
			model.addAttribute("categoriaData", categoriaData);
			model.addAttribute("puestoData", puestoData);	
			model.addAttribute("establecimientoData", establecimientoService.dataByEstablecimientoId(puestoData.getEstablecimientoId()));

			
			return "vendedor/addComercialProductoToPuesto";
		} else {
			return "redirect:/user/login";
		}
	}

	@RequestMapping(value = "submitAddComercialProductoToPuesto", method = RequestMethod.POST)
	public String submitAddComercialProductoToPuesto(Model model,
			@RequestParam(name = "categoriaId", required = true, defaultValue = "0") Long categoriaId,
			@RequestParam(name = "puestoId", required = true, defaultValue = "0") Long puestoId,
			@RequestParam(name = "productoId", required = true, defaultValue = "0") Long productoId,
			@RequestParam(name = "medidaId", required = true, defaultValue = "0") Long medidaId,
			@RequestParam(name = "cantidad", required = true, defaultValue = "0") Double cantidad,
			@RequestParam(name = "precio", required = true, defaultValue = "0") Double precio) {
			
			ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
					.currentRequestAttributes();
			HttpSession httpSession = servletRequestAttributes.getRequest().getSession();
			
			if (httpSession.getAttribute("isLogged") != null) {
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
				
				return "redirect:/categorias/listAllCategoriesToAddPuesto?puestoId="+puestoId;
			} else {
				return "redirect:/user/login";
			}
	}
}
