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

	@RequestMapping(value = "/")
	public String test(Model model) {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpSession httpSession = servletRequestAttributes.getRequest().getSession();

		httpSession.setAttribute("personaId", (long) 1);

		ObjectMapper obj = new ObjectMapper();
		Iterable<Object> cat = categoriaService
				.listCategoriasByPersonaPuestoWithProducts((long) httpSession.getAttribute("personaId"));

		for (Object item : cat) {
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
