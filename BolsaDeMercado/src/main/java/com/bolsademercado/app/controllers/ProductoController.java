package com.bolsademercado.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolsademercado.app.models.Producto;
import com.bolsademercado.app.services.ProductoService;

@Controller
@RequestMapping(value = "/productos")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@RequestMapping(value = "listProductosByCategoriaToAdd", method = RequestMethod.GET)
	public String listProductosByCategoriaToAdd(Model model, @RequestParam(name = "categoriaId", required = true, defaultValue = "0") Long categoriaId, @RequestParam(name = "puestoId", required = true, defaultValue = "0") Long puestoId) {
		
		Iterable<Producto> productList = productoService.listAllProductosByCategory(categoriaId);
		
		model.addAttribute("productList", productList);
		model.addAttribute("categoriaId", categoriaId);
		model.addAttribute("puestoId", puestoId);
		
		return "vendedor/listProductosByCategoriaToAdd";
	}
}
