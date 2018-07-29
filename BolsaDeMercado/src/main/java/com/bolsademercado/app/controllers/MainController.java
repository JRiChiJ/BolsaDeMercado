package com.bolsademercado.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsademercado.app.models.Categoria;
import com.bolsademercado.app.services.CategoriaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MainController {

	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value= "/")
	public String test(Model model) {
		ObjectMapper obj = new ObjectMapper();
		Iterable<Categoria> cat = categoriaService.listarCategorias("%pru%");
		
		for(Categoria item : cat) {
			try {
				System.out.println(obj.writeValueAsString(item));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return "layout/layout";
	}
	
}
