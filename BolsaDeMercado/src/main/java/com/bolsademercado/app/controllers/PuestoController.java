package com.bolsademercado.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolsademercado.app.services.PuestoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = "/puestos")
public class PuestoController {
	@Autowired
	PuestoService puestoService;
	
	@RequestMapping(value = "/listAllPuestosByEstablecimiento", method = RequestMethod.GET)
	public String listAllPuestosByEstablecimiento(Model model,
			@RequestParam(name = "establecimientoId", required = true, defaultValue = "0") Long establecimientoId) {
		
		
		Iterable<Object> puestoList = puestoService.listAllPuestosByEstablecimiento(establecimientoId);
		model.addAttribute("puestoList", puestoList);
		
		
		
		return "vendedor/listaEstablecimientos";
	}
}
