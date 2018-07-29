package com.bolsademercado.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bolsademercado.app.services.CategoriaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MainController {

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(value = "/admin")
	public String test(Model model) {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpSession httpSession = servletRequestAttributes.getRequest().getSession();
		
		if (httpSession.getAttribute("isLogged") != null) {
			return "redirect:/establecimientos/listAllEstablecimientosByPersona";
		} else {
			return "redirect:/user/login";
		}
	}
	
	@RequestMapping(value ="/")
	public String visitor(Model model) {
		return "redirect:/visitor/home";
	}

}
