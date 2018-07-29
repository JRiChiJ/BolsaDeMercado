package com.bolsademercado.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolsademercado.app.services.CategoriaService;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@RequestMapping(value = "listCategoriasByPersonaPuestoWithProducts", method = RequestMethod.GET)
	public String listCategoriasByPersonaPuestoWithProducts(Model model,
			@RequestParam(name = "puestoId", required = true, defaultValue = "0") Long puestoId) {
		
		Iterable<Object> categoriaList = categoriaService.listCategoriasByPersonaPuestoWithProducts(puestoId);
		model.addAttribute("categoriaList", categoriaList);
		
		return "vendedor/listCategoriasByPersonaPuestoWithProducts";
	}

}
