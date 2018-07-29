package com.bolsademercado.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolsademercado.app.services.EstablecimientoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = "/establecimientos")
public class EstablecimientoController {
	
	@Autowired
	EstablecimientoService establecimientoService;

	@RequestMapping(value = "/listAllEstablecimientosByPersona", method = RequestMethod.GET)
	public String listAllEstablecimientosByPersona(Model model,
			@RequestParam(name = "personaId", required = false, defaultValue = "0") Long personaId) {
		
		ObjectMapper obj = new ObjectMapper();
		Iterable<Object> establecimientoList = establecimientoService.listAllEstablecimientosByPersona(personaId);
		model.addAttribute("establecimientoList", establecimientoList);
		
		for(Object item : establecimientoList) {
			try {
				System.out.println(obj.writeValueAsString(item));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "vendedor/listaEstablecimientos";
	}

}
