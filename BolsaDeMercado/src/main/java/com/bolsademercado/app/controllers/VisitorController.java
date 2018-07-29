package com.bolsademercado.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsademercado.app.services.ProductoService;

@Controller
@RequestMapping(value = "/visitor")
public class VisitorController {

	@Autowired
	ProductoService productoService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		Iterable<Object> productList = productoService.listAllProductosForVisitors();
		
		model.addAttribute("productList", productList);
		
		return "visitor/home";
	}
	
	
}
