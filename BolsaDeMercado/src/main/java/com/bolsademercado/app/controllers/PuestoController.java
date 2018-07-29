package com.bolsademercado.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/puestos")
public class PuestoController {

	@RequestMapping(value = "/listAllPuestosByPersona", method = RequestMethod.GET)
	public String listAllPuestosByPersona(Model model,
			@RequestParam(name = "personaId", required = false, defaultValue = "0") Long personaId) {
		return "vendedor/listaPuestos";
	}

}
