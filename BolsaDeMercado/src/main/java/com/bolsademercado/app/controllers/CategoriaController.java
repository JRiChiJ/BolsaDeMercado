package com.bolsademercado.app.controllers;

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
import com.bolsademercado.app.models.Puesto;
import com.bolsademercado.app.services.CategoriaService;
import com.bolsademercado.app.services.EstablecimientoService;
import com.bolsademercado.app.services.PuestoService;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	PuestoService puestoService;
	
	@Autowired
	EstablecimientoService establecimientoService;
	
	@RequestMapping(value = "listAllCategoriesToAddPuesto", method = RequestMethod.GET)
	public String listAllCategoriesToAddPuesto(Model model, @RequestParam(name = "puestoId", required = true, defaultValue = "0") Long puestoId) {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpSession httpSession = servletRequestAttributes.getRequest().getSession();
		
		if (httpSession.getAttribute("isLogged") != null) {
			Puesto puestoData = puestoService.dataById(puestoId);
			Iterable<Categoria> categoriaList = categoriaService.listarCategorias();
			model.addAttribute("categoriaList", categoriaList);
			model.addAttribute("puestoId", puestoId);
			model.addAttribute("puestoData", puestoData);	
			model.addAttribute("establecimientoData", establecimientoService.dataByEstablecimientoId(puestoData.getEstablecimientoId()));
			
			return "vendedor/listAllCategoriesToAddPuesto";
		} else {
			return "redirect:/user/login";
		}
		
		
	}

	@RequestMapping(value = "listCategoriasByPersonaPuestoWithProducts", method = RequestMethod.GET)
	public String listCategoriasByPersonaPuestoWithProducts(Model model,
			@RequestParam(name = "puestoId", required = true, defaultValue = "0") Long puestoId) {
				
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpSession httpSession = servletRequestAttributes.getRequest().getSession();
		
		if (httpSession.getAttribute("isLogged") != null) {
			Iterable<Object> categoriaList = categoriaService.listCategoriasByPersonaPuestoWithProducts(puestoId);
			model.addAttribute("categoriaList", categoriaList);
			model.addAttribute("puestoId", puestoId);
			
			return "vendedor/listCategoriasByPersonaPuestoWithProducts";
		} else {
			return "redirect:/user/login";
		}
		
		
	}

}
