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

		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpSession httpSession = servletRequestAttributes.getRequest().getSession();

		Iterable<Object> puestoList = puestoService.listAllPuestosByEstablecimiento(establecimientoId,
				(long) httpSession.getAttribute("personaId"));
		
		ObjectMapper obj = new ObjectMapper();
		for (Object item : puestoList) {
			try {
				System.out.println(obj.writeValueAsString(item));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addAttribute("puestoList", puestoList);

		return "vendedor/listAllPuestosByEstablecimiento";
	}
}
