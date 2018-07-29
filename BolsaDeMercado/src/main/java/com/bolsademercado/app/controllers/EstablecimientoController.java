package com.bolsademercado.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bolsademercado.app.services.EstablecimientoService;

@Controller
@RequestMapping(value = "/establecimientos")
public class EstablecimientoController {

	@Autowired
	EstablecimientoService establecimientoService;

	@RequestMapping(value = "/listAllEstablecimientosByPersona", method = RequestMethod.GET)
	public String listAllEstablecimientosByPersona(Model model) {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpSession httpSession = servletRequestAttributes.getRequest().getSession();
		
		if (httpSession.getAttribute("isLogged") != null) {
			Iterable<Object> establecimientoList = establecimientoService
					.listAllEstablecimientosByPersona((long) httpSession.getAttribute("personaId"));
			model.addAttribute("establecimientoList", establecimientoList);
			
			return "vendedor/listaEstablecimientos";
		} else {
			return "redirect:/user/login";
		}
		
	}

}
